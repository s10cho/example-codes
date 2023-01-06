package org.example.person.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.person.annotation.PersonMention;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@PersonMention(mention = "반가워요.")
public class PersonInfo implements Person {
    
    private String name;

    private int age;
}
