package com.spring.sample.async;

import java.util.stream.IntStream;

import com.spring.sample.async.service.MailService;
import com.spring.sample.async.service.MessageService;
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

    private final MailService mailService;

    private final MessageService messageService;

    public static void main(String[] args) {
        ApplicationContext run = SpringApplication.run(Application.class, args);
        int exit = SpringApplication.exit(run);
        System.exit(exit);
    }

    @Override
    public void run(String... args) {
        IntStream.rangeClosed(1, 10000)
            .mapToObj(value -> "message " + value)
            .forEach(messageService::sendMessage);

        IntStream.rangeClosed(1, 10000)
            .mapToObj(value -> "mail " + value)
            .forEach(mailService::sendMail);
    }

    @Override
    public int getExitCode() {
        return 0;
    }
}
