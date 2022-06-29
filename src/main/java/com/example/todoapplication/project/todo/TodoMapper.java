package com.example.todoapplication.project.todo;

import com.example.todoapplication.util.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TodoMapper extends GenericMapper<TodoDto,Todo> {

}
