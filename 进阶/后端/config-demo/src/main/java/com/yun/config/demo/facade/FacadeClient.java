package com.yun.config.demo.facade;

// 门面模式的门面
// 面试常考 策略模式和模板模式
public class FacadeClient {
    private BedRoomLight bedRoomLight = new BedRoomLight();
    private LivingRoomLight livingRoomLight = new LivingRoomLight();

    public void allOn() {
        bedRoomLight.on();
        livingRoomLight.on();
    }

    public void allOff() {
        bedRoomLight.off();
        livingRoomLight.off();
    }

}
