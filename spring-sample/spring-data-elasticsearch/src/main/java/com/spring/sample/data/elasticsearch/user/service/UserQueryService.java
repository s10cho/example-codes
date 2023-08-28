package com.spring.sample.data.elasticsearch.user.service;

import java.util.List;

import com.spring.sample.data.elasticsearch.user.domain.UserQuery;
import com.spring.sample.data.elasticsearch.user.dto.ReadUser;
import com.spring.sample.data.elasticsearch.user.repository.UserQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserQueryService {

    private final UserQueryRepository userQueryRepository;

    public List<ReadUser> findAll(UserQuery query) {
        return userQueryRepository.findAll(query).stream()
            .map(ReadUser::new)
            .toList();
    }
}
