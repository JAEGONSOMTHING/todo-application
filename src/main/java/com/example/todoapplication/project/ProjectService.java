package com.example.todoapplication.project;

import com.example.todoapplication.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectParticipantRepository participantRepository;
    private final ProjectMapper projectMapper;

    public ProjectDto createProject(ProjectDto projectDto, User user) {
        Project project = projectMapper.toEntity(projectDto);
        project.generateInviteCode();
        projectRepository.save(project);

        setCreatorToProjectManager(user, project);

        return projectMapper.toDto(project);
    }

    private void setCreatorToProjectManager(User user, Project project) {
        participantRepository.save(new ProjectParticipant(project.getId(), user.getId(), ProjectParticipant.Role.MANAGER));
    }

    public void deleteProject(Long projectId) {
        projectRepository.deleteById(projectId);
    }

    public ProjectDto updateProject(ProjectDto projectDto) {
        Project project = projectRepository.findById(projectDto.getId()).orElseThrow(() -> new IllegalArgumentException("Project not exist"));
        projectMapper.updateFromDto(projectDto, project);
        return projectMapper.toDto(project);
    }

    public void inviteUserByInviteCode(String inviteCode, User user) {
        Project project = projectRepository.findByInviteCode(inviteCode).orElseThrow(() -> new IllegalArgumentException("Project not exist"));
        if (userIsNotParticipant(project, user)) {
            participantRepository.save(new ProjectParticipant(project.getId(), user.getId(), ProjectParticipant.Role.PARTICIPANT));
        }
    }

    private boolean userIsNotParticipant(Project project, User user) {
        return !participantRepository.existsByProjectIdAndUserId(project.getId(), user.getId());
    }


}
