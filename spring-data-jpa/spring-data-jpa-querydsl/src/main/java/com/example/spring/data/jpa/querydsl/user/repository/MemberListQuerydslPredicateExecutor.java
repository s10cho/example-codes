package com.example.spring.data.jpa.querydsl.user.repository;

import com.example.spring.data.jpa.querydsl.user.domain.Member;
import org.springframework.data.querydsl.ListQuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface MemberListQuerydslPredicateExecutor extends CrudRepository<Member, Long>, ListQuerydslPredicateExecutor<Member> {
}
