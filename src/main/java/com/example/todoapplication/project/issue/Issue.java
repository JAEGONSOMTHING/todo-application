package com.example.todoapplication.project.issue;

import com.example.todoapplication.project.Project;
import com.example.todoapplication.project.todo.Todo;
import com.example.todoapplication.user.User;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Project project;

    @ManyToOne
    private Todo todo;
    private String content;



}
