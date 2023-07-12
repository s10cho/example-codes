package com.example.counter.domain;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class CounterTest {

    @Test
    void countTest() {
        Counter counter = new Counter();
        counter.increment();
        counter.increment();
        counter.increment();
        log.debug("counter.getCount() = {}", counter.getCount());

        Assertions.assertThat(counter.getCount()).isNotZero();
    }

    @Test
    @DisplayName("Multi thread test")
    void threadTest() throws InterruptedException {
        Counter counter = new Counter();

        // Increment the counter in a separate thread
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        }).start();

        // Increment the counter in another separate thread
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        }).start();

        // Wait for the threads to finish
        Thread.sleep(1000);

        log.debug("counter.getCount() = {}", counter.getCount());
        Assertions.assertThat(counter.getCount()).isNotZero();
    }
}
