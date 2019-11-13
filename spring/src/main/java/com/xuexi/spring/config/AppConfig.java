package com.xuexi.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Autowired
    private User user;

    // user = null
    @Bean
    public User user() {
        return new User();
    }

    // user != null
    @Bean
    public Role role() {
        return new Role();
    }
}
