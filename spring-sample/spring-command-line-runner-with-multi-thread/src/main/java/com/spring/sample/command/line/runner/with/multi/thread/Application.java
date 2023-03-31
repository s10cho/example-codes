package com.spring.sample.command.line.runner.with.multi.thread;

import java.util.List;
import java.util.stream.IntStream;

import com.spring.sample.command.line.runner.with.multi.thread.domain.MyData;
import com.spring.sample.command.line.runner.with.multi.thread.service.MyProcessorService;
import com.spring.sample.command.line.runner.with.multi.thread.service.MyProcessorThread;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.task.TaskExecutor;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class Application implements CommandLineRunner, ExitCodeGenerator {

    private final MyProcessorService myProcessorService;

    private final TaskExecutor taskExecutor;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        List.of(
                List.of(MyData.of("A"), MyData.of("B"), MyData.of("C")),
                List.of(MyData.of("D"), MyData.of("E"), MyData.of("F")),
                List.of(MyData.of("AA"), MyData.of("BB"), MyData.of("CC")),
                List.of(MyData.of("DD"), MyData.of("EE"), MyData.of("FF"))
            ).stream()
            .map(myDataList -> new MyProcessorThread(myProcessorService, myDataList))
            .forEach(taskExecutor::execute);

        log.info("----------------------------------------------------------------------------------------------------");

        IntStream.rangeClosed(1, 1000)
            .mapToObj(MyData::of)
            .map(List::of)
            .map(myDataList -> new MyProcessorThread(myProcessorService, myDataList))
            .forEach(taskExecutor::execute);
    }

    @Override
    public int getExitCode() {
        return 0;
    }
}
