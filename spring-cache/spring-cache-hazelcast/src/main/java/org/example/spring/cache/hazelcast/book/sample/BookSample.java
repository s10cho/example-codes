package org.example.spring.cache.hazelcast.book.sample;

import java.util.stream.Stream;

import lombok.RequiredArgsConstructor;
import org.example.spring.cache.hazelcast.book.domain.Book;
import org.example.spring.cache.hazelcast.book.repository.BookRepository;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookSample {

    private final BookRepository bookRepository;

    @EventListener(classes = ContextStartedEvent.class)
    public void run() {
        Stream.of(
            new Book(1L, "book01"),
            new Book(2L, "book02"),
            new Book(3L, "book03")
        ).forEach(bookRepository::save);
    }
}
