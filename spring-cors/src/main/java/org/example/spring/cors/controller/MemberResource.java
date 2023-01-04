package org.example.spring.cors.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.example.spring.cors.domain.Member;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("members")
public class MemberResource {

    @GetMapping
    public List<Member> findAll() {
        return List.of(
            new Member(1, "hong"),
            new Member(2, "kim"),
            new Member(2, "lee")
        );
    }
}
