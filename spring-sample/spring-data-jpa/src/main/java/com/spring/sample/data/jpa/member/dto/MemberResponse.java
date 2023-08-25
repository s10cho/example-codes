package com.spring.sample.data.jpa.member.dto;

import com.spring.sample.data.jpa.member.domain.Member;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberResponse {

    private long id;

    private String name;

    public MemberResponse(Member member) {
        this.id = member.getId();
        this.name = member.getName();
    }
}
