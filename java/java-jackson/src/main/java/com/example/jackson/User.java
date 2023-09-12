package com.example.jackson;

import static com.example.jackson.JsonUtil.toJson;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class User {

    private String id;

    private UserType type;

    @Override
    public String toString() {
        return toJson(this);
    }
}
