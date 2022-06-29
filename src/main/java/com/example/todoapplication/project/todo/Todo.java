package com.example.todoapplication.project.todo;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Todo {

    enum Status{
        TODO, IN_PROGRESS, IN_REVIEW, DONE;

        @JsonCreator
        public static Status of(String s){
            return Status.valueOf(s.toUpperCase());
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(table = "project", name = "id")
    private Long projectId;
    @JoinColumn(table = "user", name = "id")
    private Long userId;
    private String title;
    private String content;
    private LocalDateTime time;

    private Status status;


    public void changeStatus(Status status){
        this.status = status;
    }


}
