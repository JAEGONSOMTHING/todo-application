package com.example.todoapplication.project;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Project {
    @Builder
    public Project(String inviteCode, String name, String description, LocalDateTime startTime, LocalDateTime endTime, boolean publicOption) {
        this.inviteCode = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.publicOption = publicOption;
        verifyStarTimeIsBeforeEndTime();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String inviteCode;
    private String name;


    private String description;

    @NotNull
    private LocalDateTime startTime;
    @NotNull
    private LocalDateTime endTime;
    private boolean publicOption;

    public void setPublicOption(boolean publicOption) {
        this.publicOption = publicOption;
    }


    private static String generateInviteCode() {
        return UUID.randomUUID().toString();
    }


    private void verifyStarTimeIsBeforeEndTime() {
        if (startTime == null || endTime == null || startTime.isAfter(endTime)) {
            throw new IllegalArgumentException("check the time");
        }
    }

}
