package com.example.organization.domain;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrganizationUtil {

    public static List<String> getUserIds(List<OrganizationUnit>... lists) {
        return Arrays.stream(lists)
            .flatMap(Collection::stream)
            .map(OrganizationUnit::getUserIds)
            .flatMap(Collection::stream)
            .distinct()
            .sorted()
            .toList();
    }
}

