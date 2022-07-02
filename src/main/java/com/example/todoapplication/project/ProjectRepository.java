package com.example.todoapplication.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project,Long> {
    List<Project> findByPublicOption(boolean publicOption);

    @Query("select p from Project p where p.id in (select distinct pt.projectId from ProjectParticipant pt where :userId = pt.userId)")
    List<Project> findProjectByUser(Long userId);

    Optional<Project> findByInviteCode(String inviteCode);

}
