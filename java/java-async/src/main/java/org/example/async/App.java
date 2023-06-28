package org.example.async;

import java.util.function.Consumer;

import lombok.extern.slf4j.Slf4j;
import org.example.async.task.FindTask;
import org.example.async.task.ModifyTask;
import org.example.async.task.RegiterTask;
import org.example.async.task.RemoveTask;

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
