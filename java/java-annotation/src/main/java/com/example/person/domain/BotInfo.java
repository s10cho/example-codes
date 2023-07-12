package com.example.person.domain;

import com.example.person.annotation.Mention;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Mention(value = "안녕하세요.")
public class BotInfo implements Person {

    private String name;

    private int age;
}
