package com.example.json.flat;

import com.example.core.util.JsonUtil;
import com.example.json.flat.member.Address;
import com.example.json.flat.member.User;
import com.example.json.flat.member.UserMetadata;
import com.example.json.flat.member.UserName;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

    public static void main(String[] args) {
        UserName name = new UserName("gildong", "hong");
        Address address = new Address("123 Main St", "10001");
        UserMetadata option = new UserMetadata(address);
        User user = new User(1L, name, "https://www.profile.com", "hong@mail.com", option);

        log.debug("user -> json: {}", user);
        String flattened = JsonUtil.toFlattenJson(user);
        log.debug("json -> flattened: {}", flattened);
        log.debug("flattened -> json, user: {}", JsonUtil.fromFlattenJson(flattened, User.class));
    }
}
