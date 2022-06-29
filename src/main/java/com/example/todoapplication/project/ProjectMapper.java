package com.example.todoapplication.project;

import com.example.todoapplication.util.GenericMapper;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectMapper extends GenericMapper<ProjectDto, Project> {

}
