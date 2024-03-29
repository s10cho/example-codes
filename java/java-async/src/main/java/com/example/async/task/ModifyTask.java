package com.example.async.task;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ModifyTask implements Task {

    @Override
    public String process(String value) {
        try {
            value = value.concat(" -> [%s]".formatted(getClass().getSimpleName()));
            log.info("{} process", getClass().getSimpleName());
            Thread.sleep(value.length() * 100);
        } catch (InterruptedException e) {
            log.info("Task process fail. task: {}", getClass().getSimpleName());
            Thread.currentThread().interrupt();
        }

        return value;
    }
}
