package com.example.todoapplication.project;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Project {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String inviteCode;
    private String name;


    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean isPublic;



    public ProjectDto toDto(){
        ProjectDto projectDto = new ProjectDto();
        projectDto.setName(name);
        projectDto.setDescription(description);
        projectDto.setStartTime(startTime);
        projectDto.setEndTime(endTime);
        projectDto.setPublic(isPublic);
        return projectDto;
    }
}
