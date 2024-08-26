package com.yun.demo.proxy;

import com.yun.demo.aspect.CostTime;
import org.springframework.stereotype.Component;

@Component
public class RealHouseSubject implements HouseSubject{

    @CostTime
    @Override
    public void rent() {
        System.out.println("我是房东，我要出租房屋");
    }
}
