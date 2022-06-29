package com.example.todoapplication.project;

import com.example.todoapplication.user.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

@ExtendWith(MockitoExtension.class)
class ProjectServiceTest {
    @Mock
    private ProjectRepository projectRepository;
    @Mock
    private ProjectParticipantRepository projectParticipantRepository;
    @InjectMocks
    private ProjectService projectService;



    void allPublicProjects() {

    }

    @Test
    void successCreateProjectTest(){
        //given
        Account account = new Account();
        ProjectDto projectDto = new ProjectDto();
        projectDto.setName("test");
        projectDto.setDescription("createTest");
        projectDto.setStartTime(LocalDateTime.of(2000,3,15,00,00));
        projectDto.setEndTime(LocalDateTime.of(2000,3,16,00,00));
        projectDto.setPublic(true);

        //when
        ProjectDto returnDto = projectService.createProject(projectDto, account);

        //then
        Assertions.assertTrue(projectDto.getName().equals(returnDto.getName()));
        Assertions.assertTrue(projectDto.getStartTime().equals(returnDto.getStartTime()));
        Assertions.assertTrue(projectDto.getEndTime().equals(returnDto.getEndTime()));
        Assertions.assertTrue(projectDto.getDescription().equals(returnDto.getDescription()));
        Assertions.assertTrue(projectDto.isPublic() == returnDto.isPublic());
    }

}