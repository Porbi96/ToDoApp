package pl.porbi.todoapp.admin.service;

import pl.porbi.todoapp.dto.TodoDto;

import java.util.List;

public interface TodoManagementService {
    void deleteAllTodos();

    List<TodoDto> getAllTodos();

}
