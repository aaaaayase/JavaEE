package com.yun.config.demo.controller;

import com.yun.config.demo.model.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("yml")
public class YmlController {
    @Value("${floor1.floor21}")
    private String floor1;
    @Value("${floor1.floor22}")
    private String floor2;
    @Value("${floor1.floor23}")
    private String floor3;

    @Value("${string.str1}")
    private String str1;
    @Value("${string.str2}")
    private String str2;
    @Value("${string.str3}")
    private String str3;

    @Autowired
    private Student student;

    @PostConstruct // 加上这个注解的方法 程序一启动就会执行该方法
    public void outPut() {
        System.out.println(floor1);
        System.out.println(floor2);
        System.out.println(floor3);

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);

        System.out.println(student);
    }
}
