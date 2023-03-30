package com.spring.sample.command.line.runner;

import java.util.stream.IntStream;

import com.spring.sample.command.line.runner.service.DomainEventPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class Application implements CommandLineRunner, ExitCodeGenerator {

    private final DomainEventPublisher domainEventPublisher;

    public static void main(String[] args) {
        ApplicationContext run = SpringApplication.run(Application.class, args);
        int exit = SpringApplication.exit(run);
        System.exit(exit);
    }

    @Override
    public void run(String... args) {
        IntStream.rangeClosed(1, 100)
            .mapToObj(value -> "event " + value)
            .forEach(domainEventPublisher::sendEvent);
    }

    @Override
    public int getExitCode() {
        return 0;
    }
}
