package com.yun.demo.aspect;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class CostTimeAspect {

    @SneakyThrows
    @Around("@annotation(com.yun.demo.aspect.CostTime)")
    public Object costTime(ProceedingJoinPoint joinPoint) {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        log.info(joinPoint.getSignature().toShortString() + " 耗时：" + (System.currentTimeMillis() - start) + "ms");
        return result;
    }
}
