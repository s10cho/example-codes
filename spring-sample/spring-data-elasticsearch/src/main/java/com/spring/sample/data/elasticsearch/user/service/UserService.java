package com.spring.sample.data.elasticsearch.user.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.StreamSupport;

import com.spring.sample.data.elasticsearch.user.doc.UserDoc;
import com.spring.sample.data.elasticsearch.user.domain.User;
import com.spring.sample.data.elasticsearch.user.dto.UpdateUser;
import com.spring.sample.data.elasticsearch.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAll() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
            .map(UserDoc::toDomain)
            .toList();
    }

    public User find(String userId) {
        return userRepository.findById(userId)
            .map(UserDoc::toDomain)
            .orElseThrow(() -> new NoSuchElementException("Not fount user. userId: " + userId));
    }

    public void register(User user) {
        if (exists(user.getUserId())) {
            throw new DuplicateKeyException("This is a duplicate key. userId: " + user.getUserId());
        }
        userRepository.save(new UserDoc(user));
    }

    public void modify(String userId, UpdateUser updateUser) {
        User findUser = find(userId);
        findUser.changeName(updateUser.getName());
        userRepository.save(new UserDoc(findUser));
    }

    public void remove(String userId) {
        userRepository.deleteById(userId);
    }

    public boolean exists(String userId) {
        return userRepository.findById(userId).isPresent();
    }
}
