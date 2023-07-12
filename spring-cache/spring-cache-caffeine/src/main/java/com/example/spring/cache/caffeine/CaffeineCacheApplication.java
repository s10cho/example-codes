package com.example.spring.cache.caffeine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;

@EnableCaching
@SpringBootApplication
public class CaffeineCacheApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(CaffeineCacheApplication.class);
        run.start();
    }
}
