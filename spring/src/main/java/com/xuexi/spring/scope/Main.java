package com.xuexi.spring.scope;

import java.awt.Color;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Main {
    @Autowired
    private ApplicationContext context;

    @Bean
    @Scope(scopeName = "prototype")
    public Color color() {
        Random random = new Random();
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    @Bean
    @Scope(scopeName = "singleton")
    public ColorFrame colorFrame() {
        return new ColorFrame() {
            @Override
            protected Color getColor() {
                return context.getBean(Color.class);
            }
        };
    }

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com");
        while (true) {
            Thread.sleep(100);
            context.getBean(ColorFrame.class).showOnRandomPlace();

        }
    }
}
