package com.spring.sample.data.elasticsearch.user.sample;

import java.util.List;

import com.spring.sample.data.elasticsearch.user.domain.User;
import com.spring.sample.data.elasticsearch.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
@RequiredArgsConstructor
public class UserSample implements CommandLineRunner {

    private final UserService userService;

    @Override
    public void run(String... args) {
        List.of(
            new User("hong", "홍길동"),
            new User("kim", "김길동"),
            new User("lee", "이길동")
        ).forEach(userService::register);
    }
}
