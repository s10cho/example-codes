package com.spring.sample.async.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageService {

    @Async("messageAsyncExecutor")
    public void sendMessage(String message) {
        try {
            Thread.sleep(1000);
            log.info("[{}] send message: {}", Thread.currentThread().getName(), message);
        } catch (InterruptedException e) {
            log.error("fail.", e);
            Thread.currentThread().interrupt();
        }
    }
}
