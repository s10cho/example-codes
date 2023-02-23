package com.spring.sample.override.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MyService {

    private final BookService bookService;

    public String doSomething() {
        log.info("MyService doSomething method");
        String bookName = bookService.getBookName();
        return "My ".concat(bookName);
    }
}
