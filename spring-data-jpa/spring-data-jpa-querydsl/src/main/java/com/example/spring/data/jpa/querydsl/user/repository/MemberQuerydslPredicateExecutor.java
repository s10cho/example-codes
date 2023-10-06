package com.example.spring.data.jpa.querydsl.user.repository;

import java.util.List;
import java.util.stream.StreamSupport;

import com.example.spring.data.jpa.querydsl.user.domain.Member;
import com.querydsl.core.types.Predicate;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface MemberQuerydslPredicateExecutor extends CrudRepository<Member, Long>, QuerydslPredicateExecutor<Member> {

    default List<Member> search(Predicate predicate) {
        return StreamSupport.stream(findAll(predicate).spliterator(), false).toList();
    }
}
