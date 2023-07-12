package com.example.spring.cloud.eureka.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringCloudEurekaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaServiceApplication.class, args);
    }
}
