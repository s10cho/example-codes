package org.example.organization.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.example.core.util.CamelcaseUtil;

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
