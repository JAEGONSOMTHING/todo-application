package com.example.todoapplication.project;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class ProjectServiceTest {
    @Mock
    ProjectRepository projectRepository;
    @Mock
    ProjectParticipantRepository projectParticipantRepository;
    @Spy
    ProjectMapperImpl projectMapper;
    @InjectMocks
    ProjectService projectService;



    void allPublicProjects() {

    }

    @DisplayName("프로젝트 생성 성공")
    @Test
    void successCreateProjectTest(){

        ProjectDto projectDto = new ProjectDto();
        projectDto.setName("test");
        projectDto.setDescription("createTest");
        projectDto.setStartTime(LocalDateTime.of(2000,3,15,00,00));
        projectDto.setEndTime(LocalDateTime.of(2000,3,16,00,00));
        projectDto.setPublicOption(true);

        //when
        ProjectDto returnDto = projectService.createProject(projectDto, 1L);


        //then
        assertThat(projectDto).usingRecursiveComparison().isEqualTo(returnDto);

    }
    @DisplayName("시간 잘못 입력 프로젝트 생성 실패")
    @Test
    void createProjectFail(){
        ProjectDto projectDto = new ProjectDto();
        projectDto.setName("test");
        projectDto.setDescription("createTest");
        projectDto.setStartTime(LocalDateTime.of(2000,3,15,00,00));
        projectDto.setEndTime(LocalDateTime.of(2000,3,13,00,00));
        projectDto.setPublicOption(true);

        assertThrows(IllegalArgumentException.class, ()->projectService.createProject(projectDto,1L));

    }


}