package com.spring.sample.data.elasticsearch.user.doc;

import com.spring.sample.data.elasticsearch.user.domain.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Document(indexName = "users")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDoc {

    @Id
    private String userId;

    private String name;

    public UserDoc(User user) {
        this.userId = user.getUserId();
        this.name = user.getName();
    }

    public User toDomain() {
        return new User(
            userId,
            name
        );
    }
}
