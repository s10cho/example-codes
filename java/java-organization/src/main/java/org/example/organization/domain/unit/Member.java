package org.example.organization.domain.unit;

import static org.example.core.util.JsonUtil.toJson;
import static org.example.organization.domain.OrganizationUnitType.MEMBER;

import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.organization.domain.OrganizationUnit;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Member extends OrganizationUnit {

    public Member(String id, String name) {
        super(id, name, MEMBER);
    }

    @Override
    public List<String> getUserIds() {
        return List.of(getId());
    }

    @Override
    public String toString() {
        return toJson(this);
    }
}

