package com.example.organization.domain;

import com.example.core.util.CamelcaseUtil;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum OrganizationUnitType {
    MEMBER;

    @JsonCreator
    public static OrganizationUnitType of(String value) {
        return OrganizationUnitType.valueOf(CamelcaseUtil.toSnakeName(value));
    }

    @JsonValue
    public String camelName() {
        return CamelcaseUtil.toCamelName(name());
    }
}
