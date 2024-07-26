package com.yun.demo.controller;

import com.yun.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;
    // fianl修饰属性要么直接赋值 要么在构造函数中赋值（并且是所有的构造函数都得给final修饰的属性赋值）

    // 属性注解
    // 优点：简单直接
    // 缺点：不能注入final类型修饰的 只能用于ioc容器
//    @Autowired
//    private UserService userService;
    // context也可以通过属性注解来进行注入 因为spring会管理默认的该对象
//    @Autowired
//    private ApplicationContext context;

    // Setter方法注解
    // 优点：方便在注入之后，重新对该对象进行修改
    // 缺点：不能注入final属性 注入对象可能遭到改变
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }

    // 构造方法注解
    // 优点：可以注入final修饰的属性 注入的对象不会被修改。。。（具体见文件）
    // 缺点：注入多个对象的时候代码会很繁琐
    // 构造方法比较特殊
    // 当只有一个全参构造函数时 你会发现程序运行起来是没问题的
    // 因为spring通过反射来创建对象 创建对象肯定要调用构造函数
    // 此时只有一个构造函数 spring就去它管理的对象中去找有没有参数中对应的对象 从而自动注入
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
    // 但是如果我们多加上一个无参构造函数就不行了，因为此时spring创建对象就会调用无参构造函数
    // 毕竟没人愿意去做更麻烦的事
    // 此时解决办法就是将Autowired注解加上
    public UserController() {
    }

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void sayHi() {
        userService.sayHi();
        System.out.println("Hi,UserController...");
    }
}
