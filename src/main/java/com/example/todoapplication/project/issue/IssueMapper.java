package com.example.todoapplication.project.issue;

import com.example.todoapplication.util.EntityMapper;
import org.mapstruct.Mapper;

import javax.persistence.EntityManager;

@Mapper(componentModel = "spring")
public interface IssueMapper extends EntityMapper<Issue, IssueDto> {
}
