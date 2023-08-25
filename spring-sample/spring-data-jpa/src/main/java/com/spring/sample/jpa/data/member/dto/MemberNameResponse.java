package com.spring.sample.jpa.data.member.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberNameResponse {

    private String name;

    public MemberNameResponse(MemberName memberName) {
        this.name = memberName.getName();
    }
}
