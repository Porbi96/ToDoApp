package pl.porbi.todoapp.admin.api.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import pl.porbi.todoapp.admin.api.TodoManagementApi;
import pl.porbi.todoapp.admin.service.TodoManagementService;
import pl.porbi.todoapp.dto.TodoDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoManagementApiController implements TodoManagementApi {

    private final TodoManagementService todoManagementService;

    @Override
    public ResponseEntity<Void> deleteAllTodos() {
        todoManagementService.deleteAllTodos();
        return null;
    }

    @Override
    public ResponseEntity<List<TodoDto>> getAllTodos() {
        return ResponseEntity.ok(todoManagementService.getAllTodos());
    }
}
