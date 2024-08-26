package com.yun.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(212)
@Slf4j
@Component
@Aspect
public class MyAspectDemo4 {

    @Before("com.yun.demo.aspect.MyAspectDemo.pt()")
    public void doBefore(JoinPoint joinPoint) {
        log.info("执行MyAspectDemo4.doBefore方法");
    }

    @After("com.yun.demo.aspect.MyAspectDemo.pt()")
    public void doAfter() {
        log.info("执行MyAspectDemo4.doAfter方法");
    }

}
