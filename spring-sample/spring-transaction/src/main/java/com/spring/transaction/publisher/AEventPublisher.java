package com.spring.transaction.publisher;

import com.spring.transaction.publisher.event.AEvent;
import com.spring.transaction.util.ThreadUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class AEventPublisher {

    @Async("eventPublisherExecutor")
    @Transactional
    public void send(AEvent event) {
        log.info("send event. [before] {}", event);
        log.info("event start");
        ThreadUtil.sleep(300);
        log.info("send event. [after] {}", event);
        log.info("event end");
    }
}
