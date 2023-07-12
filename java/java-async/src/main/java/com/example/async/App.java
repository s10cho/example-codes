package com.example.async;

import java.util.function.Consumer;

import com.example.async.task.FindTask;
import com.example.async.task.ModifyTask;
import com.example.async.task.RegiterTask;
import com.example.async.task.RemoveTask;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

    public static void main(String[] args) {
        Consumer<String> process = ((Consumer<String>) value -> log.info("Start value: {}", value))
            .andThen(new RegiterTask()::process)
            .andThen(new FindTask()::process)
            .andThen(new ModifyTask()::process)
            .andThen(new RemoveTask()::process);
        process.accept("value");
    }
}
