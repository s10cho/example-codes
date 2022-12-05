package com.example.spring.member.dto;

import com.example.spring.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberResponse {

    private String email;

    public static MemberResponse of(Member member) {
        return new MemberResponse(member.getEmail());
    }
}
