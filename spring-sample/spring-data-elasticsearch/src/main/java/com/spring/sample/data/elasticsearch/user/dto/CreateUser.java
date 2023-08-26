package com.spring.sample.data.elasticsearch.user.dto;

import com.spring.sample.data.elasticsearch.user.domain.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateUser {

    private String userId;

    private String name;

    public User toDomain() {
        return new User(
            userId,
            name
        );
    }
}
