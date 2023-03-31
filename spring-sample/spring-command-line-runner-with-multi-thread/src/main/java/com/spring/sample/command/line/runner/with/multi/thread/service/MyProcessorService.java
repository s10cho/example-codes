package com.spring.sample.command.line.runner.with.multi.thread.service;

import com.spring.sample.command.line.runner.with.multi.thread.domain.MyData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MyProcessorService implements MyProcessor {

    @Override
    public void send(MyData myData) {
        try {
            Thread.sleep(1000);
            log.info("send success: {}", myData);
        } catch (InterruptedException e) {
            log.warn("send fail");
        }
    }
}
