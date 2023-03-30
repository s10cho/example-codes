package com.spring.sample.command.line.runner.service;

import static com.spring.sample.command.line.runner.util.SleepUtil.sleep;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DomainAsyncService {

    @Async
    public void sendMail(String name) {
        sleep(1000);
        log.debug("send {}", name);
    }
}
