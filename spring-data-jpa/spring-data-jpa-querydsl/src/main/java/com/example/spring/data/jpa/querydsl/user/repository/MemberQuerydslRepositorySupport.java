package com.example.spring.data.jpa.querydsl.user.repository;

import static com.example.spring.data.jpa.querydsl.user.domain.QMember.member;
import static com.example.spring.data.jpa.querydsl.user.repository.query.MemberQuery.nameLike;
import static com.example.spring.data.jpa.querydsl.user.repository.query.MemberQuery.stateMessageLike;

import java.util.List;

import com.example.spring.data.jpa.querydsl.user.domain.Member;
import com.example.spring.data.jpa.querydsl.user.domain.MemberQuery;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
public class MemberQuerydslRepositorySupport extends QuerydslRepositorySupport {

    public MemberQuerydslRepositorySupport() {
        super(Member.class);
    }

    public List<Member> findAll(MemberQuery query) {
        return from(member)
            .where(
                nameLike(query.getName()),
                stateMessageLike(query.getStateMessage())
            ).fetch();
    }
}
