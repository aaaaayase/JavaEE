package com.yun.demo.proxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLibMethodInterceptor implements MethodInterceptor {

    private Object target;

    public CGLibMethodInterceptor(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("我是代理，开始代理");
        Object result=proxy.invoke(target,args);
        System.out.println("我是代理，结束代理");
        return result;
    }
}
