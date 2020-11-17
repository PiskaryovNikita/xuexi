package com.xuexi.spring.proxy;

public class AService implements Service {

    public void doA() {
        System.out.println("doing A");
        doB();
    }

    public void doB() {
        System.out.println("doing B");
    }
}
