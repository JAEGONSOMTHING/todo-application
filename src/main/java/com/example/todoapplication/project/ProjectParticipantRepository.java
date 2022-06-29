package com.example.todoapplication.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface ProjectParticipantRepository extends JpaRepository<ProjectParticipant, Long> {

    Set<Long> findParticipantsIdByProjectIdIs(Long projectId);

    boolean existsByProjectIdAndUserId(Long projectId, Long userId);
}
