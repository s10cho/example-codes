package org.example.spring.cache.caffeine.user.sample;

import java.util.stream.Stream;

import lombok.RequiredArgsConstructor;
import org.example.spring.cache.caffeine.user.domain.User;
import org.example.spring.cache.caffeine.user.repository.UserRepository;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserSample {

    private final UserRepository userRepository;

    @EventListener(classes = ContextStartedEvent.class)
    public void run() {
        Stream.of(
            new User(1L, "user01", "user01@gamil.com"),
            new User(2L, "user02", "user02@gamil.com"),
            new User(3L, "user03", "user03@gamil.com")
        ).forEach(userRepository::save);
    }
}
