package com.example.todoapplication.project.issue;

import com.example.todoapplication.project.Project;
import com.example.todoapplication.project.todo.Todo;
import com.example.todoapplication.user.User;
import lombok.Data;

import javax.persistence.ManyToOne;

@Data
public class IssueDto {

    private Long id;
    private Long userId;
    private Long projectId;
    private Long todoId;
    private String title;
    private String content;
}
