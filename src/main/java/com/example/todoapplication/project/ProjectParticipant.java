package com.example.todoapplication.project;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ProjectParticipant {
    static enum Role{
        MANAGER, PARTICIPANT
    }

    @Id
    @GeneratedValue
    private Long id;

    @JoinColumn(table = "project", name = "id")
    private Long projectId;

    @JoinColumn(table = "account", name = "id")
    private Long userId;

    @Enumerated(EnumType.STRING)
    private Role role;

    public ProjectParticipant(Long projectId, Long userId, Role role) {
        this.projectId = projectId;
        this.userId = userId;
        this.role = role;
    }
}
