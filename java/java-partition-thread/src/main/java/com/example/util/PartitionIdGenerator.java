package com.example.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PartitionIdGenerator {

    private static final Map<String, Integer> partitionKeyMap = new ConcurrentHashMap<>();

    private static int currentPartitionId = 0;

    private static int partitionSize = 4;

    public static void setPartitionSize(int partitionSize) {
        PartitionIdGenerator.partitionSize = partitionSize - 1;
    }

    public static int generateByPartitionKey(String partitionKey) {
        return partitionKeyMap.computeIfAbsent(partitionKey, key -> getPartitionId());
    }

    public static int generateByPartitionKey(Integer partitionKey) {
        return generateByPartitionKey(partitionKey.toString());
    }

    public static int generateByPartitionKey(Long partitionKey) {
        return generateByPartitionKey(partitionKey.toString());
    }


    private static synchronized int getPartitionId() {
        if (currentPartitionId > partitionSize) {
            currentPartitionId = 0;
        }
        return currentPartitionId++;
    }
}
