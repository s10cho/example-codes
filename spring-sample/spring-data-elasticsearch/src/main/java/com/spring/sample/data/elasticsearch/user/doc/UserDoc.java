package com.spring.sample.data.elasticsearch.user.doc;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.spring.sample.data.elasticsearch.user.domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE
)
@Getter
@Document(indexName = "users")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDoc implements Persistable<String> {

    @Id
    private String userId;

    private String name;

    @CreatedDate
    @Field(type = FieldType.Date, format = DateFormat.date_hour_minute_second_millis)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Field(type = FieldType.Date, format = DateFormat.date_hour_minute_second_millis)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime lastModifiedDate;

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

    @Override
    public String getId() {
        return userId;
    }

    @Override
    public boolean isNew() {
        return userId == null || createdDate == null;
    }
}
