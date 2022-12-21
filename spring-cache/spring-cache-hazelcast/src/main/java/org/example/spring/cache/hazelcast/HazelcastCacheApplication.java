package org.example.spring.cache.hazelcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;

@EnableCaching
@SpringBootApplication
public class HazelcastCacheApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(HazelcastCacheApplication.class);
        run.start();
    }
}