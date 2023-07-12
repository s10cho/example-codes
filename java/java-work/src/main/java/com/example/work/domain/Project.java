package com.example.work.domain;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Project implements Work {

    private String id;

    private String title;

    private String description;

    private String status;

    private List<Assignee> assignees;

    private List<Task> tasks;
}
