package com.example.spring.data.jpa.querydsl.user.repository;

import static com.example.spring.data.jpa.querydsl.user.repository.MemberRepository.nameLike;
import static com.example.spring.data.jpa.querydsl.user.repository.MemberRepository.stateMessageLike;
import static com.example.spring.data.jpa.querydsl.user.repository.MemberRepository.where;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.StreamSupport;

import com.example.spring.data.jpa.querydsl.user.domain.Member;
import com.example.spring.data.jpa.querydsl.user.domain.MemberQuery;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    void findAllTest() {
        memberRepository.save(new Member(1L, "홍길동", "http://placekitten.com/97/97", ""));
        memberRepository.save(new Member(2L, "김길동", "http://placekitten.com/97/97", ""));
        memberRepository.save(new Member(3L, "이상한", "http://placekitten.com/97/97", ""));

        MemberQuery query = MemberQuery.builder()
            .name("길동")
            .build();

        List<Member> list = memberRepository.search(
            where(
                nameLike(query.getName()),
                stateMessageLike(query.getStateMessage())
            ));
        log.info("list.size(): {}", list.size());

        assertThat(list).hasSize(2);

        list.stream()
            .forEach(member -> {
                assertThat(member.getName()).isNotEmpty();
                assertThat(member.getName()).contains(query.getName());
            });
    }

    private List<Member> toList(Iterable<Member> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false).toList();
    }
}
