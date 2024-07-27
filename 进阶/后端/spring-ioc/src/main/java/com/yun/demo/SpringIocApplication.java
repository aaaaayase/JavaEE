package com.yun.demo;

import com.yun.demo.component.UserComponent;
import com.yun.demo.config.UserConfig;
import com.yun.demo.controller.UserController;
import com.yun.demo.model.UserInfo;
import com.yun.demo.repository.UserRepo;
import com.yun.demo.service.UserService;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// 扫描程序代码的默认路径是此文件所在的路径
// 推荐使用默认路径 符合标准
// 如果想要修改路径可以使用ComponentScan注解来指定路径 并且可以同时指定多个路径
public class SpringIocApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringIocApplication.class, args);

        UserController userController = context.getBean(UserController.class);
        userController.sayHi();

        // 使用类名来创建对象注意一点 如果开头两个字母都是大写那么你填进去的类名可以不变就是原类名
        // 反之你填入的类名需要将第一个大写字母转为小写之后填入
        UserService userService = (UserService) context.getBean("userService");
        userService.sayHi();
        System.out.println(userService);

        UserService userService2 = context.getBean(UserService.class);
        userService2.sayHi();
        System.out.println(userService2);

        UserService userService3 = context.getBean("userService", UserService.class);
        userService3.sayHi();
        System.out.println(userService3);

        UserRepo userRepo = context.getBean(UserRepo.class);
        userRepo.sayHi();

        UserComponent userComponent = context.getBean(UserComponent.class);
        userComponent.sayHi();

        UserConfig userConfig = context.getBean(UserConfig.class);
        userConfig.sayHi();

        UserInfo userInfo1 = (UserInfo) context.getBean("userInfo1");
        System.out.println(userInfo1);

        UserInfo u1 = (UserInfo) context.getBean("u1");
        System.out.println(u1);

        UserInfo u2 = (UserInfo) context.getBean("u2");
        System.out.println(u2);

        UserController userController1 = (UserController) context.getBean("userController");
        userController1.sayHi();
    }

}
