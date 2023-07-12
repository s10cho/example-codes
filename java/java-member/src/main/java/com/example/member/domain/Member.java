package com.example.member.domain;

import com.example.core.util.JsonUtil;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Member {

    private String id;

    private String name;

    public static void main(String[] args) {
        Member member = new Member("hong", "홍길동");
        log.debug("member = " + member);
    }

    @Override
    public String toString() {
        return JsonUtil.toJson(this);
    }
}
