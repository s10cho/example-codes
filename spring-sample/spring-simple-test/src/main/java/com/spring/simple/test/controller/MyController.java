package com.spring.simple.test.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("my")
public class MyController {

    @GetMapping
    public String message(@Value("${my.message:hi}") String message) {
        return message;
    }
}
