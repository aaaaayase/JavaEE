package com.yun.demo.controller;


import com.yun.demo.aspect.CostTime;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test2")
public class TestController2 {

    @CostTime
    @RequestMapping("/tt1")
    public String t1() {
        return "t1";
    }

    @RequestMapping("/tt2")
    public Integer t2() {
        int a = 10 / 0;
        return 10;
    }

    @RequestMapping("/t3")
    public boolean t3() {
        return true;
    }
    
}
