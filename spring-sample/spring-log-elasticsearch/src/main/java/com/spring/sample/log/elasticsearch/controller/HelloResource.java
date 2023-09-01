package com.spring.sample.log.elasticsearch.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("hello")
public class HelloResource {

    @GetMapping
    public String hello() {
        log.info("hello~!!!");
        return "hello";
    }
}
