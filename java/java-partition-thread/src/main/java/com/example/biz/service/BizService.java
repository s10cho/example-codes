package com.example.biz.service;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class BizService {

    private static final Random RANDOM = new Random();

    public void process() {
        try {
            long start = System.currentTimeMillis();

            Thread.sleep((RANDOM.nextInt(5) + 1) * 1000L);

            log.info("elapsed time {}(ms)", System.currentTimeMillis() - start);
        } catch (InterruptedException e) {
            log.error("Interrupted!", e);
            Thread.currentThread().interrupt();
        }
    }
}
