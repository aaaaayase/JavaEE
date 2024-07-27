package com.yun.demo.ioc.v2;

public class Framework {

    private Bottom bottom;

    public Framework(Bottom bottom) {

        bottom = bottom;
        System.out.println("framework--init");
    }
}
