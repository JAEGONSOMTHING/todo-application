package com.example.todoapplication.project.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class TodoService {
    private final TodoRepository todoRepository;
    private final TodoMapper todoMapper;

    public TodoDto createTodo(TodoDto todoDto){
        Todo saved = todoRepository.save(todoMapper.toEntity(todoDto));
        return todoMapper.toDto(saved);
    }
    public void deleteTodo(Long todoId){
        todoRepository.deleteById(todoId);
    }
    public TodoDto updateTodo(TodoDto todoDto){
        Todo todo = todoRepository.findById(todoDto.getId()).orElseThrow(() -> new IllegalArgumentException("Todo not exist"));
        todoMapper.updateFromDto(todoDto, todo);
        return todoMapper.toDto(todo);
    }

}
