package org.example;

import static org.example.core.util.JsonUtil.toJson;

import java.util.Comparator;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.Person;

@Slf4j
public class App {

    public static void main(String[] args) {
        List<Person> people = List.of(
            new Person("a", "lee", 10),
            new Person("b", "lee", 9),
            new Person("c", "lee", 8),
            new Person("d", "lee", 7),
            new Person("e", "lee", 6),
            new Person("f", "lee", 5),
            new Person("g", "lee", 4),
            new Person("h", "lee", 3),
            new Person("i", "lee", 2),
            new Person("j", "lee", 1)
        );

        Comparator<Person> cmp = Comparator.comparing(Person::lastName)
            .thenComparing(Person::firstName)
            .thenComparing(Person::age)
            .reversed();

        List<Person> list = people.stream()
            .sorted(cmp)
            .toList();
        log.debug("list: {}", toJson(list));
    }
}
