package com.example.todoapplication.project;

import com.example.todoapplication.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectParticipantRepository participantRepository;
    public List<ProjectDto> allPublicProjects(){
        return projectRepository
                .findByIsPublic(true).stream()
                .map(Project::toDto).collect(Collectors.toList());
    }

    public List<ProjectDto> allProjectByUsers(Long userId){
        return null;

    }


    public ProjectDto createProject(ProjectDto projectDto, User user){
        Project project = Project.builder().name(projectDto.getName())
                .description(projectDto.getDescription())
                .startTime(projectDto.getStartTime())
                .endTime(projectDto.getEndTime())
                .isPublic(projectDto.isPublic())
                .inviteCode(generateInviteCode())
                .build();

        projectRepository.save(project);
        setCreatorToProjectManager(user, project);

        return project.toDto();
    }

    private void setCreatorToProjectManager(User user, Project project) {
        participantRepository.save(new ProjectParticipant(project,user, ProjectParticipant.Role.MANAGER));
    }

    private String generateInviteCode(){
        return UUID.randomUUID().toString();
    }
}
