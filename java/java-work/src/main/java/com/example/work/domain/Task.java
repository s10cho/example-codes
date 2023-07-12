package com.example.work.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Task implements Work {

    private String id;

    private String title;

    private String description;

    private String status;

    private String assigneeId;
}
