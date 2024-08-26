package com.yun.demo.proxy;

public class HouseProxy implements HouseSubject {

    private RealHouseSubject realHouseSubject;

    public HouseProxy(RealHouseSubject realHouseSubject) {
        this.realHouseSubject = realHouseSubject;
    }

    @Override
    public void rent() {
        System.out.println("我是代理，开始代理");
        realHouseSubject.rent();
        System.out.println("我是代理，结束代理");
    }
}
