package com.spring.transaction.publisher;

import com.spring.transaction.publisher.event.AEvent;
import com.spring.transaction.util.ThreadUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
@RequiredArgsConstructor
public class ATransactionEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Transactional
    public void send(AEvent event) {
        log.info("send event. [before] {}", event);
        applicationEventPublisher.publishEvent(event);
    }

    @Async("eventPublisherExecutor")
    @TransactionalEventListener
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void doAfter(AEvent event) {
        log.info("event start");
        ThreadUtil.sleep(300);
        log.info("send event. [after] {}", event);
        log.info("event end");
    }
}
