package com.example.spring.member.service;

import com.example.spring.member.dto.MemberResponse;
import com.example.spring.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberResponse findMemberInfoById(Long memberId) {
        return memberRepository.findById(memberId)
            .map(MemberResponse::of)
            .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));
    }

    public MemberResponse findMemberInfoByEmail(String email) {
        return memberRepository.findByEmail(email)
            .map(MemberResponse::of)
            .orElseThrow(() -> new RuntimeException("유저 정보가 없습니다."));
    }
}
