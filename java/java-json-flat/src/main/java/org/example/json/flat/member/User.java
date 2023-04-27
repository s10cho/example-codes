package org.example.json.flat.member;

import static org.example.core.util.JsonUtil.toJson;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class User {

    private long id;

    private String name;

    private String profileUrl;

    private String email;

    private UserMetadata metadata;

    @Override
    public String toString() {
        return toJson(this);
    }
}
