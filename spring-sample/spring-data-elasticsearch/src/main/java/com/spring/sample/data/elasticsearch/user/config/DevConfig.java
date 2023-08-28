package com.spring.sample.data.elasticsearch.user.config;

import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;

import java.io.IOException;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.indices.CreateIndexRequest;
import co.elastic.clients.elasticsearch.indices.CreateIndexResponse;
import co.elastic.clients.elasticsearch.indices.DeleteIndexRequest;
import co.elastic.clients.elasticsearch.indices.DeleteIndexResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Order(HIGHEST_PRECEDENCE)
@Component
@RequiredArgsConstructor
public class DevConfig implements CommandLineRunner {

    private final ElasticsearchClient elasticsearchClient;

    @Override
    public void run(String... args) {
        try {
            deleteIndex();
            createIndex();
        } catch (Exception e) {
            log.error("delete fail.", e);
        }
    }

    private DeleteIndexResponse deleteIndex() throws IOException {
        return elasticsearchClient.indices().delete(
            new DeleteIndexRequest.Builder()
                .index("users")
                .build()
        );
    }

    private CreateIndexResponse createIndex() throws IOException {
        return elasticsearchClient.indices().create(
            new CreateIndexRequest.Builder()
                .index("users")
                .build()
        );
    }
}
