package com.example.todoapplication.notification;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
    @JoinColumn(table = "account", name = "id")
    private Long userId;

    private String url;

    public Notification(String content, Long userId, String url) {
        this.content = content;
        this.userId = userId;
        this.url = url;
    }
}
