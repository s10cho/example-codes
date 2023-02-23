package com.spring.sample.override.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Slf4j
@Primary
@Service
public class NewMyService extends MyService {

    private final BookService newBookService;

    public NewMyService(BookService bookService) {
        super(null);
        newBookService = bookService;
    }

    @Override
    public String doSomething() {
        log.info("NewMyService doSomething method");
        String bookName = newBookService.getBookName();
        return "New My ".concat(bookName);
    }
}
