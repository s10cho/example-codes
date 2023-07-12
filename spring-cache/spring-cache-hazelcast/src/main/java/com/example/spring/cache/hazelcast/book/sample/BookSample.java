package com.example.spring.cache.hazelcast.book.sample;

import java.util.stream.Stream;

import com.example.spring.cache.hazelcast.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import com.example.spring.cache.hazelcast.book.domain.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookSample implements CommandLineRunner {

    private final BookRepository bookRepository;

    @Override
    public void run(String... args) {
        Stream.of(
            new Book(1L, "book01"),
            new Book(2L, "book02"),
            new Book(3L, "book03")
        ).forEach(bookRepository::save);
    }
}
