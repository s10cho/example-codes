package com.example.organization.domain.unit;

import static com.example.organization.domain.OrganizationUnitType.MEMBER;

import java.util.List;

import com.example.core.util.JsonUtil;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.example.organization.domain.OrganizationUnit;

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
        return JsonUtil.toJson(this);
    }
}

