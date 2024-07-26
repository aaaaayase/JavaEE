package com.yun.demo.ioc.v2;

public class Bottom {

    private Tire tire;

    public Bottom(Tire tire) {

        this.tire = tire;
        System.out.println("Bottom--init");
    }
}
