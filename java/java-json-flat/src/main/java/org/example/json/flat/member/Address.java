package org.example.json.flat.member;

import static org.example.core.util.JsonUtil.toJson;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Address {

    private String street;

    private String zip;

    @Override
    public String toString() {
        return toJson(this);
    }
}
