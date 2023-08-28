package com.spring.sample.data.elasticsearch.user.controller;

import java.util.List;

import com.spring.sample.data.elasticsearch.user.domain.UserQuery;
import com.spring.sample.data.elasticsearch.user.dto.ReadUser;
import com.spring.sample.data.elasticsearch.user.service.UserQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("users/query")
public class UserQueryResource {

    private final UserQueryService userQueryService;

    @GetMapping
    public List<ReadUser> findAll(
        @RequestParam(name = "name", required = false) String name
    ) {
        return userQueryService.findAll(
            UserQuery.builder()
                .name(name)
                .build()
        );
    }
}
