package com.example.todoapplication.project;

import com.example.todoapplication.util.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectMapper extends EntityMapper<Project, ProjectDto> {

}
