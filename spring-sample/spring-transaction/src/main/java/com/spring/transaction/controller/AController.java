package com.spring.transaction.controller;

import com.spring.transaction.service.AService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("sample")
public class AController {

    private final AService aService;

    @PutMapping("process/{id}")
    public void process(
        @PathVariable String id
    ) {
        log.info("start controller");
        aService.process(id);
        log.info("end controller");
    }
}
