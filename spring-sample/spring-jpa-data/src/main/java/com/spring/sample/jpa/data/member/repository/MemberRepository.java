package com.spring.sample.jpa.data.member.repository;

import java.util.List;

import com.spring.sample.jpa.data.member.domain.Member;
import com.spring.sample.jpa.data.member.dto.MemberName;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {

    @Query("select new com.spring.sample.jpa.data.member.dto.MemberName(m.name) "
        + "from Member m")
    List<MemberName> findAllMemberNames();
}
