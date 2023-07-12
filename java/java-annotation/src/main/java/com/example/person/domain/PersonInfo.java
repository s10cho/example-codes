package com.example.person.domain;

import com.example.person.annotation.Mention;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Mention(value = "반가워요.")
public class PersonInfo implements Person {

    private String name;

    private int age;
}
