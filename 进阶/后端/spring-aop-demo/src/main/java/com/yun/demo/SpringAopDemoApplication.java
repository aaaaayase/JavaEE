package com.yun.demo;

import com.yun.demo.controller.TestController;
import com.yun.demo.proxy.HouseSubject;
import com.yun.demo.proxy.RealHouseSubject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAopDemoApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringAopDemoApplication.class, args);
        TestController bean = context.getBean(TestController.class);
        System.out.println(bean.getClass().toString());

        HouseSubject bean2 = (HouseSubject) context.getBean("realHouseSubject");
        System.out.println(bean2.getClass().toString());
    }

}
