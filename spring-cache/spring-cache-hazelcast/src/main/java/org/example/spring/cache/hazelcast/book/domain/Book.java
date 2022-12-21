package org.example.spring.cache.hazelcast.book.domain;

import java.io.Serializable;

public record Book(Long id, String name) implements Serializable {
}
