package org.example.core.util;

import static java.lang.String.join;
import static java.util.Objects.isNull;

import java.io.IOException;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JsonUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String toJson(Object obj) {
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException();
        }
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String toFlattenJson(Object obj) {
        try {
            ObjectNode objectNode = objectMapper.createObjectNode();
            flatten(null, objectMapper.readTree(toJson(obj)), objectNode);
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectNode);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException();
        }
    }

    public static <T> T fromFlattenJson(String flattenedJson, Class<T> clazz) {
        try {
            return objectMapper.readValue(unFlatten(flattenedJson), clazz);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static void flatten(String prefix, JsonNode node, ObjectNode flattened) {
        if (node.isValueNode()) {
            flattened.put(prefix, node.asText());
        } else if (node.isArray()) {
            for (int i = 0; i < node.size(); i++) {
                flatten(prefix + "[" + i + "]", node.get(i), flattened);
            }
        } else if (node.isObject()) {
            ObjectNode objectNode = (ObjectNode) node;
            objectNode.fieldNames().forEachRemaining(key -> {
                String nextPrefix = isNull(prefix) ? key : join(".", prefix, key);
                flatten(nextPrefix, objectNode.get(key), flattened);
            });
        }
    }

    private static String unFlatten(String flattenedJson) throws JsonProcessingException {
        JsonNode root = objectMapper.createObjectNode();
        objectMapper.readTree(flattenedJson).fields().forEachRemaining(entry -> {
            String[] keys = entry.getKey().split("\\.");
            JsonNode value = entry.getValue();
            JsonNode node = root;

            for (int i = 0; i < keys.length - 1; i++) {
                node = node.path(keys[i]).isObject() ? node.path(keys[i]) : ((ObjectNode) node).putObject(keys[i]);
            }

            String lastKey = keys[keys.length - 1];
            JsonNode childNode = node.get(lastKey);

            if (childNode instanceof ArrayNode arrayNode) {
                arrayNode.add(value);
            } else {
                JsonNode jsonNode = Optional.ofNullable(childNode).orElse(node);
                ObjectNode jsonNodes = (ObjectNode) jsonNode;
                jsonNodes.set(lastKey, value);
            }
        });

        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);
    }
}

