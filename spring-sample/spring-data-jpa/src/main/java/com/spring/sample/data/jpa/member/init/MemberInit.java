package com.spring.sample.data.jpa.member.init;

import java.util.stream.Stream;

import com.spring.sample.data.jpa.member.domain.Member;
import com.spring.sample.data.jpa.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberInit implements CommandLineRunner {

    private final MemberRepository memberRepository;

    @Override
    public void run(String... args) {
        Stream.of(
            new Member("kim"),
            new Member("lee"),
            new Member("hong")
        ).forEach(memberRepository::save);
    }
}
