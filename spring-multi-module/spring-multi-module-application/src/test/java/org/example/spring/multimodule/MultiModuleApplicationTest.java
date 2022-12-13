package org.example.spring.multimodule;

import static org.assertj.core.api.Assertions.assertThat;

import org.example.spring.multimodule.home.service.HomeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MultiModuleApplicationTest {

    @Autowired
    private HomeService myService;

    @Test
    void contextLoads() {
        assertThat(myService.message()).isNotNull();
    }
}