package com.example.spring.data.jpa.querydsl.user.repository;

import static com.example.spring.data.jpa.querydsl.user.repository.query.MemberQuery.nameLike;
import static com.example.spring.data.jpa.querydsl.user.repository.query.MemberQuery.stateMessageLike;
import static com.example.spring.data.jpa.querydsl.user.repository.query.MemberQuery.where;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.example.spring.data.jpa.querydsl.user.domain.Member;
import com.example.spring.data.jpa.querydsl.user.domain.MemberQuery;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class MemberQuerydslPredicateExecutorTest {

    @Autowired
    MemberQuerydslPredicateExecutor memberQuerydslPredicateExecutor;

    @BeforeEach
    void setup() {
        memberQuerydslPredicateExecutor.save(new Member(1L, "홍길동", "http://placekitten.com/97/97", "오늘은 맑음"));
        memberQuerydslPredicateExecutor.save(new Member(2L, "김길동", "http://placekitten.com/97/97", "오늘은 흐림"));
        memberQuerydslPredicateExecutor.save(new Member(3L, "이상한", "http://placekitten.com/97/97", "오늘은 화창"));
    }

    @Test
    void findAllTest1() {

        MemberQuery query = MemberQuery.builder()
            .name("길동")
            .build();

        List<Member> list = memberQuerydslPredicateExecutor.search(
            where(
                nameLike(query.getName()),
                stateMessageLike(query.getStateMessage())
            ));
        log.info("list.size(): {}", list.size());

        assertThat(list).hasSize(2);

        list.forEach(member -> {
            assertThat(member.getName()).isNotEmpty();
            assertThat(member.getName()).contains(query.getName());
        });
    }

    @Test
    void findAllTest2() {
        MemberQuery query = MemberQuery.builder()
            .name("길동")
            .stateMessage("맑음")
            .build();

        List<Member> list = memberQuerydslPredicateExecutor.search(
            where(
                nameLike(query.getName()),
                stateMessageLike(query.getStateMessage())
            ));
        log.info("list.size(): {}", list.size());

        assertThat(list).hasSize(1);

        list.forEach(member -> {
            assertThat(member.getName()).isNotEmpty();
            assertThat(member.getName()).contains(query.getName());
        });
    }
}
