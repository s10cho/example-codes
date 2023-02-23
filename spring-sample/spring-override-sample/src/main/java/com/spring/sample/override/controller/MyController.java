package com.spring.sample.override.controller;

import com.spring.sample.override.service.MyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("my")
public class MyController {

    private final MyService myService;

    @GetMapping
    public String doSomething() {
        return myService.doSomething();
    }
}
