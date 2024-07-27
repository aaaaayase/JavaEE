package com.yun.demo.repository;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepo {
    public void sayHi() {
        System.out.println("Hi,UserRepo...");
    }
}
