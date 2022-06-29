package com.example.todoapplication.project.issue;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class IssueDto {

    private Long id;
    private Long userId;
    private Long projectId;
    private Long todoId;
    private String title;
    private String content;
}
