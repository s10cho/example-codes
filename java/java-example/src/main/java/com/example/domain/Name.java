package com.example.domain;

import java.util.Comparator;
import java.util.List;

import com.example.core.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Name {

    public static void main(String[] args) {
        List<String> strings = List.of("A", "B", "C", "D");

        Comparator<String> cmp = (Comparator<String>) Comparator.naturalOrder().reversed();

        List<String> list = strings.stream().sorted(cmp).toList();
        log.debug("list: {}", JsonUtil.toJson(list));
    }
}
