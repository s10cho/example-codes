package org.example.spring.cache.caffeine.user.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.example.spring.cache.caffeine.user.domain.User;
import org.example.spring.cache.caffeine.user.repository.UserRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    @Cacheable(cacheNames = "users")
    @GetMapping
    public List<User> findAll() throws InterruptedException {
        Thread.sleep(5000);
        return userRepository.findAll();
    }
}
