package org.example.member;

import static org.example.util.JsonUtil.toJson;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Member {

    private String id;

    private String name;

    private String email;

    public static void main(String[] args) {
        System.out.println(new Member("john", "존", "john@gmail.com"));
    }

    @Override
    public String toString() {
        return toJson(this);
    }
}
