package com.spring.transaction.service;

import com.spring.transaction.publisher.AEventPublisher;
import com.spring.transaction.publisher.ATransactionEventPublisher;
import com.spring.transaction.publisher.event.AEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AService {

    private final AEventPublisher aEventPublisher;

    private final ATransactionEventPublisher aTransactionEventPublisher;

    @Transactional
    public void process(String id) {
        log.info("service start");
        aEventPublisher.send(new AEvent(id));
        log.info("service end");
    }
}
