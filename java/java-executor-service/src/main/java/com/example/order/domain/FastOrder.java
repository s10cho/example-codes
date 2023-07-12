package com.example.order.domain;

import com.example.core.util.JsonUtil;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FastOrder implements Order {

    private int orderNo;

    @Override
    public String toString() {
        return JsonUtil.toJson(this);
    }

    @Override
    public void waiting() {
        waiting(1000);
    }
}
