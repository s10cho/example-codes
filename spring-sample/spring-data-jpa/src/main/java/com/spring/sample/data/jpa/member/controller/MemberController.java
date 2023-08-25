package com.spring.sample.data.jpa.member.controller;

import java.util.List;

import com.spring.sample.data.jpa.member.dto.MemberNameResponse;
import com.spring.sample.data.jpa.member.dto.MemberResponse;
import com.spring.sample.data.jpa.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping
    public List<MemberResponse> findAll() {
        return memberService.findAll();
    }

    @GetMapping("names")
    public List<MemberNameResponse> findAllMemberNames() {
        return memberService.findAllMemberNames();
    }
}
