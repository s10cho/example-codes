package com.spring.sample.data.elasticsearch.user.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class User {

    private String userId;

    private String name;

    public void changeName(String name) {
        this.name = name;
    }
}
