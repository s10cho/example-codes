package com.example.spring.data.jpa.querydsl.user.repository.query;

import static com.example.spring.data.jpa.querydsl.user.domain.QMember.member;
import static org.springframework.util.StringUtils.hasText;

import java.util.Arrays;
import java.util.Objects;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public abstract class MemberQuery {

    public static Predicate where(BooleanExpression... expressions) {
        BooleanExpression predicate = member.isNotNull();
        return Arrays.stream(expressions)
            .filter(Objects::nonNull)
            .reduce(predicate, BooleanExpression::and);
    }

    public static BooleanExpression nameLike(String value) {
        return hasText(value) ? member.name.contains(value) : null;
    }

    public static BooleanExpression stateMessageLike(String value) {
        return hasText(value) ? member.stateMessage.contains(value) : null;
    }
}
