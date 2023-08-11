package com.spring.transaction.publisher.event;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AEvent {

    private String id;

    @Override
    public String toString() {
        return "AEvent{" +
            "id='" + id + '\'' +
            '}';
    }
}
