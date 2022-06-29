package com.example.todoapplication.project;

import com.example.todoapplication.user.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectParticipantRepository participantRepository;
    private final ProjectMapper projectMapper;

    public ProjectDto createProject(ProjectDto projectDto, Account account) {
        Project project = projectMapper.toEntity(projectDto);
        project.generateInviteCode();
        projectRepository.save(project);

        setCreatorToProjectManager(account, project);

        return projectMapper.toDto(project);
    }

    private void setCreatorToProjectManager(Account account, Project project) {
        participantRepository.save(new ProjectParticipant(project.getId(), account.getId(), ProjectParticipant.Role.MANAGER));
    }

    public void deleteProject(Long projectId) {
        projectRepository.deleteById(projectId);
    }

    public ProjectDto updateProject(ProjectDto projectDto) {
        Project project = projectRepository.findById(projectDto.getId()).orElseThrow(() -> new IllegalArgumentException("Project not exist"));
        projectMapper.updateFromDto(projectDto, project);
        return projectMapper.toDto(project);
    }

    public void inviteUserByInviteCode(String inviteCode, Account account) {
        Project project = projectRepository.findByInviteCode(inviteCode).orElseThrow(() -> new IllegalArgumentException("Project not exist"));
        if (userIsNotParticipant(project, account)) {
            participantRepository.save(new ProjectParticipant(project.getId(), account.getId(), ProjectParticipant.Role.PARTICIPANT));
        }
    }

    private boolean userIsNotParticipant(Project project, Account account) {
        return !participantRepository.existsByProjectIdAndUserId(project.getId(), account.getId());
    }


}
