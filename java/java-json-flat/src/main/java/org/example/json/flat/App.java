package org.example.json.flat;

import static org.example.core.util.JsonUtil.fromFlattenJson;
import static org.example.core.util.JsonUtil.toFlattenJson;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.example.json.flat.member.Address;
import org.example.json.flat.member.User;
import org.example.json.flat.member.UserMetadata;

@Slf4j
public class App {

    public static void main(String[] args) throws JsonProcessingException {
        Address address = new Address("123 Main St", "10001");
        UserMetadata option = new UserMetadata(address);
        User user = new User(1L, "hong", "https://www.profile.com", "hong@mail.com", option);

        log.debug("user -> json: {}", user);
        String flattened = toFlattenJson(user);
        log.debug("json -> flattened: {}", flattened);
        log.debug("flattened -> json, user: {}", fromFlattenJson(flattened, User.class));
    }
}
