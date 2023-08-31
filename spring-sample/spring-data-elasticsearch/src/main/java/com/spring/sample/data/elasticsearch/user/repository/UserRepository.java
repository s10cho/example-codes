package com.spring.sample.data.elasticsearch.user.repository;

import java.util.List;

import com.spring.sample.data.elasticsearch.user.doc.UserDoc;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ElasticsearchRepository<UserDoc, String> {

    List<UserDoc> findAllByNameContains(String name);
}
