package org.example.member;

import static org.example.util.JsonUtil.toJson;

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

    private String email;

    public static void main(String[] args) {
        log.info("member: {}", new Member("john", "존", "john@gmail.com"));
    }

    @Override
    public String toString() {
        return toJson(this);
    }
}
