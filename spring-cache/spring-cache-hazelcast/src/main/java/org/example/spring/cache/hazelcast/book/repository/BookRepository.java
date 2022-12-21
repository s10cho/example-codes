package org.example.spring.cache.hazelcast.book.repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import lombok.extern.slf4j.Slf4j;
import org.example.spring.cache.hazelcast.book.domain.Book;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class BookRepository {

    private final Map<Long, Book> bookMap = new ConcurrentHashMap<>();

    public List<Book> findAll() {
        return bookMap.keySet().stream()
            .sorted()
            .map(bookMap::get)
            .toList();
    }

    public Book find(long bookId) {
        return bookMap.get(bookId);
    }

    public void save(Book book) {
        log.info("book save {}", book);
        bookMap.put(book.id(), book);
    }

    public void remove(long bookId) {
        bookMap.remove(bookId);
    }
}
