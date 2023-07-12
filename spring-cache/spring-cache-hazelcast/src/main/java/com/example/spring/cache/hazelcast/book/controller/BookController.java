package com.example.spring.cache.hazelcast.book.controller;

import java.util.List;

import com.example.spring.cache.hazelcast.book.domain.Book;
import com.example.spring.cache.hazelcast.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;

    @Cacheable(cacheNames = "books")
    @GetMapping
    public List<Book> findAll() throws InterruptedException {
        Thread.sleep(5000);
        return bookRepository.findAll();
    }
}
