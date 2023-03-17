package com.spring.sample.rest.dto;

import java.util.LinkedHashMap;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Metadata extends LinkedHashMap<String, String> {

    @Override
    public String put(String key, String value) {
        log.debug("put key {}, value{}", key, value);
        return super.put(key, value);
    }

    public void add(KeyValue keyValue) {
        put(keyValue.getKey(), keyValue.getValue());
    }
}
