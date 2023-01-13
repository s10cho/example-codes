package org.example.member.domain;

import static org.example.core.util.RandomName.getName;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class MemberTest {

    @Test
    void createTest() {
        List<Member> members = IntStream.range(1, 10)
            .mapToObj(String::valueOf)
            .map(number -> new Member("member%s".formatted(number), getName()))
            .collect(Collectors.toList());
        log.debug("members: {}", members);
    }
}
