package com.example.todoapplication.project;

import com.example.todoapplication.util.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ProjectMapper extends GenericMapper<ProjectDto, Project> {

}
