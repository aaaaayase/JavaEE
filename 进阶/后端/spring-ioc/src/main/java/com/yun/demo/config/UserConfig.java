package com.yun.demo.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    public void sayHi() {
        System.out.println("Hi,UserConfig...");
    }
}
