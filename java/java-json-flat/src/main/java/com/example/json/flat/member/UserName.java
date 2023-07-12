package com.example.json.flat.member;

import com.example.core.util.JsonUtil;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserName {

    private String first;

    private String last;

    @Override
    public String toString() {
        return JsonUtil.toJson(this);
    }
}
