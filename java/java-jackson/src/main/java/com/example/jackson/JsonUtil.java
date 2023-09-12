package com.example.jackson;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JsonUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String toJson(Object obj) {
        return toJson(obj, true);
    }

    public static String toJsonWithoutPretty(Object obj) {
        return toJson(obj, false);
    }

    public static String toJson(Object obj, boolean isPrettyPrinter) {
        try {
            return isPrettyPrinter
                ? objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj)
                : objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
