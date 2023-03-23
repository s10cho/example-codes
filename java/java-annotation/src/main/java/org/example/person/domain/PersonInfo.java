package org.example.person.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.person.annotation.Mention;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Mention(value = "반가워요.")
public class PersonInfo implements Person {

    private String name;

    private int age;
}
