package com.example.todoapplication.project;

import com.example.todoapplication.user.User;
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

    @ManyToOne
    private Project project;

    @ManyToOne
    private User user;

    @Enumerated(EnumType.STRING)
    private Role role;

    public ProjectParticipant(Project project, User user, Role role) {
        this.project = project;
        this.user = user;
        this.role = role;
    }
}
