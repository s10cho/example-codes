package com.example.order.domain;

public interface Order {

    int getOrderNo();

    void waiting();

    default void waiting(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
