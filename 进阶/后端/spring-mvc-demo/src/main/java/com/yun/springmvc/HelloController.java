package com.yun.springmvc;

import org.springframework.web.bind.annotation.*;

// requestmapping可以是类注解也可以是方法注解 这样请求的url的文件路径部分就需要满足这里设定的层次结构
@RequestMapping("/yun")
@RestController
public class HelloController {

    // 以下的注解中如果没有指定属性 那么就会赋值给注解中的value属性
    // /可以省去"/" 但是不建议，因为这是一种规范
    // 以下的requestmapping注解都是方法注解 在类上注解就是类注解
    // RequestMapping这个注解默认是可以支持所以请求方法的
    @RequestMapping("/hello1")
    public String hello1() {
        return "hello spring mvc";
    }

    // 通过指定属性method就可以设置支持的请求方法
    // 比如说这里举例只支持post和get方法
    // @RequestMapping(value = "/hello2",method = RequestMethod.GET)
    @RequestMapping(value = "/hello2", method = {RequestMethod.POST, RequestMethod.GET})
    public String hello2() {
        return "hello spring mvc";
    }

    // 只支持GET请求方法的注解
    @GetMapping("/hello3")
    public String hello3() {
        return "hello spring mvc";
    }

    // 只支持POST请求方法的注解
    @PostMapping("/hello4")
    public String hello4() {
        return "hello spring mvc";
    }
}
