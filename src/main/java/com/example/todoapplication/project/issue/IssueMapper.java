package com.example.todoapplication.project.issue;

import com.example.todoapplication.util.GenericMapper;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface IssueMapper extends GenericMapper<IssueDto, Issue> {
}
