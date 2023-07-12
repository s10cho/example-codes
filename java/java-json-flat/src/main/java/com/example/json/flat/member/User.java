package com.example.json.flat.member;

import com.example.core.util.JsonUtil;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class User {

    private long id;

    private UserName name;

    private String profileUrl;

    private String email;

    private UserMetadata metadata;

    @Override
    public String toString() {
        return JsonUtil.toJson(this);
    }
}
