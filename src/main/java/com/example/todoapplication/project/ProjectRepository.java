package com.example.todoapplication.project;

import com.example.todoapplication.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,Long> {
    List<Project> findByIsPublic(boolean isPublic);

    @Query("select distinct pt.project from ProjectParticipant pt where :user = pt.user")
    List<Project> findProjectByUser(User user);

}
