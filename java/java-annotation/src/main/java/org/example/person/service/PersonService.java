package org.example.person.service;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.function.Function;

import lombok.extern.slf4j.Slf4j;
import org.example.person.annotation.PersonMention;
import org.example.person.domain.Person;

@Slf4j
public class PersonService {

    public void say(Person person) {
        Annotation[] annotations = person.getClass().getDeclaredAnnotations();
        printPersonMention(annotations, person.getName(), person.getAge());
    }

    private void printPersonMention(Annotation[] annotations, String name, int age) {
        Function<PersonMention, String> message = mention -> String.format("%s(%s) says [%s]", name, age, mention.mention());
        Arrays.stream(annotations)
            .filter(PersonMention.class::isInstance)
            .map(PersonMention.class::cast)
            .map(message)
            .forEach(log::debug);
    }
}
