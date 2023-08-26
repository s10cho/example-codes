package com.spring.sample.data.elasticsearch.user.dto;

import com.spring.sample.data.elasticsearch.user.domain.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReadUser {

    private String userId;

    private String name;

    public ReadUser(User user) {
        this.userId = user.getUserId();
        this.name = user.getName();
    }
}
