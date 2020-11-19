package com.xuexi.spring.scope;

import java.awt.Color;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Configuration
public class Main {
    @Autowired
    private ApplicationContext context;

    /**
     * Combination of "prototype and proxy" will result new target bean for each proxy method invocation.
     * 1. Execute proxy method
     * 2. Cglib intercept, targetSource.getTarget() does beanFactory.getBean that will return new object
     * 3. Method invoked on new object
     * <p>
     * The same logic will work with proxy that is created using Java Dynamic Proxy
     */
    @Bean
    @Scope(scopeName = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Color color() {
        Random random = new Random();
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    @Bean
    public ColorFrame colorFrame() {
        return new ColorFrame();
    }

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);
        while (true) {
            ColorFrame colorFrame = context.getBean(ColorFrame.class);
            colorFrame.showOnRandomPlace();
            Thread.sleep(200);
        }
    }
}
