package com.xuexi.spring.proxy;

import java.lang.reflect.Proxy;

public class Main {
        public static void main(String[] args) {
            Service service = new AService();
            Service serviceProxy = (Service) Proxy.newProxyInstance(Main.class.getClassLoader(),
                    new Class[]{Service.class},(proxy, method, args1) -> method.invoke(service, args1));
            serviceProxy.doA();
            System.out.println(serviceProxy);
        }
}
