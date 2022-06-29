package com.example.todoapplication.project.comment;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class TodoComment{
    @Id
    @GeneratedValue
    private Long id;

    @JoinColumn(table = "user",name = "id")
    private Long userId;

    private String content;

    @CreatedDate
    private LocalDateTime commentedAt;

    @JoinColumn(table = "todo", name="id")
    private Long todoId;
}
