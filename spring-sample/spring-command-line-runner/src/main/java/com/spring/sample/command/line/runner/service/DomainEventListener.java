package com.spring.sample.command.line.runner.service;

import static com.spring.sample.command.line.runner.util.SleepUtil.sleep;

import java.util.concurrent.Future;

import com.spring.sample.command.line.runner.event.DomainEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DomainEventListener {

    @Async("threadPoolTaskExecutor")
    @EventListener
    public Future<String> sendPush(DomainEvent event) {
        sleep(1000);
        log.debug("push: {}", event.getName());
        return new AsyncResult<>("Success");
    }
}
