package com.example.todoapplication.project.todo;

import com.example.todoapplication.project.Project;
import com.example.todoapplication.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Todo {
    enum Status{
        TODO, IN_PROGRESS, IN_REVIEW, DONE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Project project;
    @ManyToOne
    private User user;
    private String title;
    private String content;
    private LocalDateTime time;
    private Status status;


    public void changeStatus(Status status){
        this.status = status;
    }



}
