package pl.porbi.todoapp.admin.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.porbi.todoapp.admin.service.TodoManagementService;
import pl.porbi.todoapp.dao.TodoRepository;
import pl.porbi.todoapp.dto.TodoDto;
import pl.porbi.todoapp.service.TodoService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoManagementServiceImpl implements TodoManagementService {

    private final TodoRepository todoRepository;

    private final TodoService todoService;

    @Override
    public List<TodoDto> getAllTodos() {
        return todoService.getAllTodos();
    }

    @Override
    public void deleteAllTodos() {
        todoRepository.deleteAll();
    }
}
