package com.example.todoapplication.project;

import com.example.todoapplication.user.User;
import com.example.todoapplication.user.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.parameters.P;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.util.ReflectionTestUtils;

import javax.transaction.Transactional;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

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
        User user = new User();
        ProjectDto projectDto = new ProjectDto();
        projectDto.setName("test");
        projectDto.setDescription("createTest");
        projectDto.setStartTime(LocalDateTime.of(2000,3,15,00,00));
        projectDto.setEndTime(LocalDateTime.of(2000,3,16,00,00));
        projectDto.setPublic(true);

        //when
        ProjectDto returnDto = projectService.createProject(projectDto, user);

        //then
        Assertions.assertTrue(projectDto.getName().equals(returnDto.getName()));
        Assertions.assertTrue(projectDto.getStartTime().equals(returnDto.getStartTime()));
        Assertions.assertTrue(projectDto.getEndTime().equals(returnDto.getEndTime()));
        Assertions.assertTrue(projectDto.getDescription().equals(returnDto.getDescription()));
        Assertions.assertTrue(projectDto.isPublic() == returnDto.isPublic());
    }

}