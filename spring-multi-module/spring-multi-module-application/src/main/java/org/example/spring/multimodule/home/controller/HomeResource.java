package org.example.spring.multimodule.home.controller;

import lombok.RequiredArgsConstructor;
import org.example.spring.multimodule.home.service.HomeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HomeResource {

    private final HomeService homeService;

    @GetMapping("/")
    public String home() {
        return homeService.message();
    }
}
