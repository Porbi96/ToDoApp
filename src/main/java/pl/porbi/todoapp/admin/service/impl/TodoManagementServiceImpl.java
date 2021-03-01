package pl.porbi.todoapp.admin.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.porbi.todoapp.admin.service.TodoManagementService;
import pl.porbi.todoapp.dao.TodoRepository;

@Service
@RequiredArgsConstructor
public class TodoManagementServiceImpl implements TodoManagementService {

    private final TodoRepository todoRepository;

    @Override
    public void deleteAllTodos() {
        todoRepository.deleteAll();
    }
}
