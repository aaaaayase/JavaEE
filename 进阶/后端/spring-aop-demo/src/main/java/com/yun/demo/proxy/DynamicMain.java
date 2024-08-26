package com.yun.demo.proxy;

import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

public class DynamicMain {
    public static void main(String[] args) {
        RealHouseSubject target = new RealHouseSubject();

      //  HouseSubject target = new RealHouseSubject();
//        HouseSubject proxy = (HouseSubject) Proxy.newProxyInstance(target.getClass().getClassLoader()
//                , new Class[]{HouseSubject.class}
//                , new JDKInvocationHandler(target));
//
//        proxy.rent();

        RealHouseSubject proxy = (RealHouseSubject) Enhancer.create(RealHouseSubject.class, new CGLibMethodInterceptor(target));
        proxy.rent();
    }
}
