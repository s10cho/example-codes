package com.spring.sample.data.elasticsearch.user.repository;

import java.io.IOException;
import java.util.List;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.spring.sample.data.elasticsearch.user.doc.UserDoc;
import com.spring.sample.data.elasticsearch.user.domain.User;
import com.spring.sample.data.elasticsearch.user.domain.UserQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.elasticsearch.client.elc.QueryBuilders;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class UserQueryRepository {

    private final ElasticsearchClient elasticsearchClient;

    public List<User> findAll(UserQuery query) {
        try {
            SearchRequest searchRequest = new SearchRequest.Builder()
                .index("users")
                .query(QueryBuilders.wildcardQueryAsQuery("name", query.getName()))
                .build();
            log.info("query: {}", searchRequest);
            SearchResponse<UserDoc> response = elasticsearchClient.search(searchRequest, UserDoc.class);
            return response.hits().hits().stream()
                .map(Hit::source)
                .map(UserDoc::toDomain)
                .toList();
        } catch (IOException e) {
            log.error("query failed.", e);
            throw new IllegalStateException(e);
        }
    }
}
