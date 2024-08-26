package com.yun.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Slf4j
@Component
@Aspect
public class MyAspectDemo {

    // 注意一点就是只有around的参数才能是ProceedingJoinPoint类型 其它只能是JoinPoint
    // 如果变成ProceedingJoinPoint类型就会不去执行通知的内容

    // 使用pointcut注解之后 其它通知就可以直接使用了 不同类的通知需要加上全限定类名
    @Pointcut("execution(* com.yun.demo.controller.*.*(..))")
    public void pt() {
    }

    ;


    @Before("pt()")
    public void doBefore(JoinPoint joinPoint) {
        log.info("执行MyAspectDemo.doBefore方法");
    }

    @After("pt()")
    public void doAfter() {
        log.info("执行MyAspectDemo.doAfter方法");
    }

}
