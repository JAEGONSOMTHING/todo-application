package com.example.todoapplication.project;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProjectDto {

    private Long id;
    private String name;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean isPublic;
}
