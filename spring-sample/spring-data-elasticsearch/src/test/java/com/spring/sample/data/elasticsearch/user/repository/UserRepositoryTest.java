package com.spring.sample.data.elasticsearch.user.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;

import com.spring.sample.data.elasticsearch.user.doc.UserDoc;
import com.spring.sample.data.elasticsearch.user.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    void setup() {
        userRepository.deleteAll();
    }

    @Test
    void findAll() {
        userRepository.save(new UserDoc(new User("hong", "홍길동")));
        userRepository.save(new UserDoc(new User("lee", "이길동")));
        userRepository.save(new UserDoc(new User("kimm", "김길동")));

        List<UserDoc> list01 = userRepository.findAllByNameContains("길동");
        log.info("list01 count: {}, users: {}", list01.size(), list01.stream().map(UserDoc::getName).collect(Collectors.joining(", ")));
        assertThat(list01).hasSize(3);

        List<UserDoc> list02 = userRepository.findAllByNameContains("이");
        log.info("list02 count: {}, users: {}", list02.size(), list02.stream().map(UserDoc::getName).collect(Collectors.joining(", ")));
        assertThat(list02).hasSize(1);
    }
}
