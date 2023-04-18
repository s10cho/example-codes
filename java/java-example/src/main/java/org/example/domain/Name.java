package org.example.domain;

import static org.example.core.util.JsonUtil.toJson;

import java.util.Comparator;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Name {

    public static void main(String[] args) {
        List<String> strings = List.of("A", "B", "C", "D");

        Comparator<String> cmp = (Comparator<String>) Comparator.naturalOrder().reversed();

        List<String> list = strings.stream().sorted(cmp).toList();
        log.debug("list: {}", toJson(list));
    }
}
