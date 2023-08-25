package com.spring.sample.data.jpa.member.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberName {

    private String name;

    public MemberName(String name) {
        this.name = name;
    }
}
