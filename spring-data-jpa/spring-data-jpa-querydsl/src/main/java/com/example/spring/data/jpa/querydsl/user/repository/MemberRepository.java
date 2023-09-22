package com.example.spring.data.jpa.querydsl.user.repository;

import static com.example.spring.data.jpa.querydsl.user.domain.QMember.member;
import static org.springframework.util.StringUtils.hasText;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.StreamSupport;

import com.example.spring.data.jpa.querydsl.user.domain.Member;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface MemberRepository extends CrudRepository<Member, Long>, QuerydslPredicateExecutor<Member> {

    static Predicate where(BooleanExpression... expressions) {
        BooleanExpression predicate = member.isNotNull();
        return Arrays.stream(expressions)
            .filter(Objects::nonNull)
            .reduce(predicate, BooleanExpression::and);
    }

    static BooleanExpression nameLike(String value) {
        return hasText(value) ? member.name.contains(value) : null;
    }

    static BooleanExpression stateMessageLike(String value) {
        return hasText(value) ? member.stateMessage.contains(value) : null;
    }

    default List<Member> search(Predicate predicate) {
        return StreamSupport.stream(findAll(predicate).spliterator(), false).toList();
    }

}
