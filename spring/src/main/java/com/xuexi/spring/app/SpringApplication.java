package com.xuexi.spring.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApplication {

    public static void main(String[] args) {
        new AnnotationConfigApplicationContext("com.xuexi.spring.config");
    }
}
