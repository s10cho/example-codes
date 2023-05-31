package com.spring.sample.jpa.data.member.service;

import java.util.List;
import java.util.stream.StreamSupport;

import com.spring.sample.jpa.data.member.dto.MemberNameResponse;
import com.spring.sample.jpa.data.member.dto.MemberResponse;
import com.spring.sample.jpa.data.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public List<MemberResponse> findAll() {
        return StreamSupport.stream(memberRepository.findAll().spliterator(), false)
            .map(MemberResponse::new)
            .toList();
    }

    public List<MemberNameResponse> findAllMemberNames() {
        return memberRepository.findAllMemberNames().stream()
            .map(MemberNameResponse::new)
            .toList();
    }
}
