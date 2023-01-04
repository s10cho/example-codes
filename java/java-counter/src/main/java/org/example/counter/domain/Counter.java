package org.example.counter.domain;

import java.util.concurrent.atomic.AtomicLong;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
public class Counter {

    private final AtomicLong count = new AtomicLong();

    public Counter(long initialValue) {
        this.count.set(initialValue);
    }

    public void increment() {
        count.incrementAndGet();
    }

    public void decrement() {
        count.decrementAndGet();
    }

    public long getCount() {
        return count.get();
    }
}
