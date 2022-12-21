package org.example.spring.cache.caffeine.user.repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import lombok.extern.slf4j.Slf4j;
import org.example.spring.cache.caffeine.user.domain.User;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class UserRepository {

    private final Map<Long, User> userMap = new ConcurrentHashMap<>();

    public List<User> findAll() {
        return userMap.keySet().stream()
            .sorted()
            .map(userMap::get)
            .toList();
    }

    public User find(long userId) {
        return userMap.get(userId);
    }

    public void save(User user) {
        log.info("user save {}", user);
        userMap.put(user.id(), user);
    }

    public void remove(long userId) {
        userMap.remove(userId);
    }
}
