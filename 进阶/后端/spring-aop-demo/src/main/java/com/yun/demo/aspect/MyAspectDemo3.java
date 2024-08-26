package com.yun.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// 使用order注解可以指定通知执行的顺序 默认情况下是按照类名的顺序进行执行并且是漏斗形
@Order(111)
@Slf4j
@Component
@Aspect
public class MyAspectDemo3 {

    @Before("com.yun.demo.aspect.MyAspectDemo.pt()")
    public void doBefore(JoinPoint joinPoint) {
        log.info("执行MyAspectDemo3.doBefore方法");
    }

    @After("com.yun.demo.aspect.MyAspectDemo.pt()")
    public void doAfter() {
        log.info("执行MyAspectDemo3.doAfter方法");
    }

}
