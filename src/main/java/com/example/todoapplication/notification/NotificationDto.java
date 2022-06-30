package com.example.todoapplication.notification;

import lombok.Data;

import javax.persistence.JoinColumn;

@Data
public class NotificationDto {
    private String content;
    private Long userId;
    private String url;
}
