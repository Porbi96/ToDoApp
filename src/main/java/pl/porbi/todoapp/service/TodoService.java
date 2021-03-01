package pl.porbi.todoapp.service;

import pl.porbi.todoapp.dto.TodoDto;

import java.util.List;
import java.util.UUID;

public interface TodoService {

    List<TodoDto> getAllTodos();

    TodoDto getTodo(UUID uuid);

    TodoDto addTodo(TodoDto todoDto);

    void deleteTodo(UUID uuid);

    TodoDto updateTodo(UUID uuid, TodoDto newTodo);

}
