package com.example.spring.data.jpa.querydsl.user.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.example.spring.data.jpa.querydsl.user.domain.Member;
import com.example.spring.data.jpa.querydsl.user.domain.MemberQuery;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class MemberQueryRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberQueryRepository memberQueryRepository;

    @Test
    void findAllTest() {
        memberRepository.save(new Member(1L, "홍길동", "http://placekitten.com/97/97", ""));
        memberRepository.save(new Member(2L, "김길동", "http://placekitten.com/97/97", ""));
        memberRepository.save(new Member(3L, "이상한", "http://placekitten.com/97/97", ""));

        MemberQuery query = MemberQuery.builder()
            .name("길동")
            .build();

        List<Member> list = memberQueryRepository.findAll(query);
        log.info("list.size(): {}", list.size());

        assertThat(list).hasSize(2);

        list.stream()
            .forEach(member -> {
                assertThat(member.getName()).isNotEmpty();
                assertThat(member.getName()).contains(query.getName());
            });
    }
}
