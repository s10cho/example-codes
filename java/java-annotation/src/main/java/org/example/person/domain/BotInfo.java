package org.example.person.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.person.annotation.Mention;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Mention(value = "안녕하세요.")
public class BotInfo implements Person {

    private String name;

    private int age;
}
