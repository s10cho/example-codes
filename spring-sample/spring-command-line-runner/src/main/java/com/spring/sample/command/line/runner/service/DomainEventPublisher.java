package com.spring.sample.command.line.runner.service;

import com.spring.sample.command.line.runner.event.DomainEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DomainEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    public void sendEvent(String name) {
        log.debug("send event: {}", name);
        DomainEvent event = new DomainEvent(name);
        applicationEventPublisher.publishEvent(event);
    }
}
