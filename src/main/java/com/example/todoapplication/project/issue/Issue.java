package com.example.todoapplication.project.issue;

import com.example.todoapplication.project.Project;
import com.example.todoapplication.project.todo.Todo;
import com.example.todoapplication.user.User;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(table = "user", name = "id")
    private Long userId;
    @JoinColumn(table = "project", name = "id")
    private Long projectId;

    @JoinColumn(table = "todo", name = "id")
    private Long todoId;
    private String title;
    private String content;

    @Builder
    public Issue(Long userId, Long projectId, Long todoId, String title, String content) {
        this.userId = userId;
        this.projectId = projectId;
        this.todoId = todoId;
        this.title = title;
        this.content = content;
    }



}
