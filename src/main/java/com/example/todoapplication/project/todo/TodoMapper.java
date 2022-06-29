package com.example.todoapplication.project.todo;

import com.example.todoapplication.util.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TodoMapper extends EntityMapper<Todo,TodoDto> {

}
