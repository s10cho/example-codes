package org.example.async;

import static java.util.concurrent.CompletableFuture.supplyAsync;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.extern.slf4j.Slf4j;
import org.example.async.task.FindTask;
import org.example.async.task.ModifyTask;
import org.example.async.task.RegiterTask;
import org.example.async.task.RemoveTask;
import org.junit.jupiter.api.Test;

@Slf4j
class AppTest {
    public static final Function<String, String> PROCESS = ((Function<String, String>) value -> value)
        .andThen(new RegiterTask()::process)
        .andThen(new FindTask()::process)
        .andThen(new ModifyTask()::process)
        .andThen(new RemoveTask()::process);

    @Test
    void singleTest() {
        long start = System.currentTimeMillis();

        String result = PROCESS.apply("Start");
        log.debug("result: {}", result);

        log.info("elapsed time {}(ms)", System.currentTimeMillis() - start);
    }

    @Test
    void multiTest() {
        long start = System.currentTimeMillis();

        IntStream.range(0, 5)
            .mapToObj(Integer::toString)
            .map(PROCESS::apply)
            .forEach(result -> log.debug("result: {}", result));

        log.info("elapsed time {}(ms)", System.currentTimeMillis() - start);
    }

    @Test
    void multiAsyncTest() throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();

        ExecutorService executor = Executors.newFixedThreadPool(5);
        Function<String, CompletableFuture<String>> asyncProcessFunction = value -> supplyAsync(() -> PROCESS.apply(value), executor).exceptionally(throwable -> "");
        List<CompletableFuture<String>> futures = IntStream.range(0, 10)
            .mapToObj(Integer::toString)
            .map(asyncProcessFunction)
            .collect(Collectors.toList());
        CompletableFuture<List<String>> results = CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]))
            .thenApply(v -> futures.stream().map(CompletableFuture::join).collect(Collectors.toList()));
        results.get().forEach(result -> log.debug("result: {}", result));

        log.info("elapsed time {}(ms)", System.currentTimeMillis() - start);
    }
}
