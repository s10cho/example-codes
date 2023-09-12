package com.example.jackson;

import static org.assertj.core.api.Assertions.assertThat;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class UserJsonTest {

    @Test
    void jsonTest() {
        User user = new User("hong", UserType.MEMBER);
        log.debug("user: {}", user);

        assertThat(user.toString()).contains("hong");
        assertThat(user.toString()).contains(UserType.MEMBER.name());
    }
}
