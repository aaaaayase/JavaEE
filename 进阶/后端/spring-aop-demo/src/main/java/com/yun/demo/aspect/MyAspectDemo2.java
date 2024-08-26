package com.yun.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(11111)
@Slf4j
@Component
@Aspect
public class MyAspectDemo2 {

    @Before("com.yun.demo.aspect.MyAspectDemo.pt()")
    public void doBefore(JoinPoint joinPoint) {
        log.info("执行MyAspectDemo2.doBefore方法");
    }

    @After("com.yun.demo.aspect.MyAspectDemo.pt()")
    public void doAfter() {
        log.info("执行MyAspectDemo2.doAfter方法");
    }

}
