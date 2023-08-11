package com.spring.transaction;

import java.util.stream.IntStream;

import com.spring.transaction.controller.AController;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class ApplicationTest {

    @Autowired
    private AController aController;

    @Test
    void applicationTest() {
        long start = System.currentTimeMillis();
        IntStream.range(0, 1000)
            .mapToObj(Integer::toString)
            .forEach(aController::process);
        log.info("elapsed time {}(ms)", System.currentTimeMillis() - start);

        //        ThreadUtil.sleep(5000);
    }
}
