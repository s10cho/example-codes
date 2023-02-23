package com.spring.sample.override.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MyService {

    public String doSomething() {
        log.info("MyService doSomething method");
        return "my";
    }
}
