package com.example.spring.data.jpa.querydsl.user.repository;

import static com.example.spring.data.jpa.querydsl.user.domain.QMember.member;
import static org.springframework.util.StringUtils.hasText;

import java.util.List;

import com.example.spring.data.jpa.querydsl.user.domain.Member;
import com.example.spring.data.jpa.querydsl.user.domain.MemberQuery;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberQueryRepository {

    private final JPAQueryFactory queryFactory;

    private static BooleanExpression nameLike(String value) {
        return hasText(value) ? member.name.contains(value) : null;
    }

    private static BooleanExpression stateMessageLike(String value) {
        return hasText(value) ? member.stateMessage.contains(value) : null;
    }

    public List<Member> findAll(MemberQuery query) {
        return queryFactory.selectFrom(member)
            .where(
                nameLike(query.getName()),
                stateMessageLike(query.getStateMessage())
            ).fetch();
    }


}

