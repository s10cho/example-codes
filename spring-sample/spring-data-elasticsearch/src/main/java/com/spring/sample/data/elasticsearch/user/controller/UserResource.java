package com.spring.sample.data.elasticsearch.user.controller;

import java.util.List;

import com.spring.sample.data.elasticsearch.user.domain.User;
import com.spring.sample.data.elasticsearch.user.dto.CreateUser;
import com.spring.sample.data.elasticsearch.user.dto.ReadUser;
import com.spring.sample.data.elasticsearch.user.dto.UpdateUser;
import com.spring.sample.data.elasticsearch.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserResource {

    private final UserService userService;

    @GetMapping
    public List<ReadUser> findAll() {
        return userService.findAll().stream()
            .map(ReadUser::new)
            .toList();
    }

    @GetMapping("{userId}")
    public ReadUser find(
        @PathVariable("userId") String userId
    ) {
        User user = userService.find(userId);
        return new ReadUser(user);
    }

    @PostMapping
    public void register(
        @RequestBody CreateUser createUser
    ) {
        User user = createUser.toDomain();
        userService.register(user);
    }

    @PutMapping("{userId}")
    public void modify(
        @PathVariable("userId") String userId,
        @RequestBody UpdateUser updateUser
    ) {
        userService.modify(userId, updateUser);
    }

    @DeleteMapping("{userId}")
    public void remove(
        @PathVariable("userId") String userId
    ) {
        userService.remove(userId);
    }
}
