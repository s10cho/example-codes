package com.spring.sample.rest.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class KeyValue {

    private String key;

    private String value;

    public KeyValue(String keyValue) {
        this.key = keyValue.substring(0, getSplitIndex(keyValue));
        this.value = keyValue.substring(getSplitIndex(keyValue) + 1);
    }

    private static int getSplitIndex(String keyValue) {
        return keyValue.indexOf(":");
    }

    public static void main(String[] args) {
        KeyValue keyValue = new KeyValue("key01:value01");
        log.debug("keyValue.getKey() = " + keyValue.getKey());
        log.debug("keyValue.getValue() = " + keyValue.getValue());
    }
}
