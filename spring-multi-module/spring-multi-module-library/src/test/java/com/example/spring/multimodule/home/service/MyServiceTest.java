package com.example.spring.multimodule.home.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest("service.message=Hello")
class MyServiceTest {

    @Autowired
    private HomeService myService;

    @Test
    void contextLoads() {
        String message = myService.message();
        assertThat(message).isNotNull();
        System.out.println("message = " + message);
    }

    @SpringBootApplication
    static class TestConfiguration {
    }

}
