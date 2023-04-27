package org.example.core.domain;

import static org.example.core.util.JsonUtil.toJson;

import java.util.HashMap;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Metadata extends HashMap<String, String> {

    @Override
    public String toString() {
        return toJson(this);
    }
}
