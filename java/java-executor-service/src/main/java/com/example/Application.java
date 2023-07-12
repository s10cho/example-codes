package com.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import com.example.order.domain.FastOrder;
import com.example.order.domain.SlowOrder;
import com.example.order.service.OrderService;

public class Application {

    public static void main(String[] args) {
        OrderService orderService = new OrderService();

        ExecutorService executor = Executors.newFixedThreadPool(100);

        IntStream.range(0, 10)
            .mapToObj(SlowOrder::new)
            .forEach(order -> executor.execute(() -> orderService.order(order)));

        IntStream.range(0, 1000)
            .mapToObj(FastOrder::new)
            .forEach(order -> executor.execute(() -> orderService.order(order)));

        executor.shutdown();
    }
}
