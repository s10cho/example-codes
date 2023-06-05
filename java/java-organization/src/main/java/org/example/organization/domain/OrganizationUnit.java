package org.example.organization.domain;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public abstract class OrganizationUnit implements Organization {

    private String id;

    private String name;

    private OrganizationUnitType type;

    public abstract List<String> getUserIds();
}
