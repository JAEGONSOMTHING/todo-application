package com.example.todoapplication.project.issue;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Issue{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(table = "account", name = "id")
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }



}
