package org.example.order.service;

import lombok.extern.slf4j.Slf4j;
import org.example.order.domain.Order;

@Slf4j
public class OrderService {

    public void order(Order order) {
        order.waiting();
        log.debug("orderNo: {}", order.getOrderNo());
    }
}
