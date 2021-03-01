package pl.porbi.todoapp.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import pl.porbi.todoapp.api.TodoApi;
import pl.porbi.todoapp.dto.TodoDto;
import pl.porbi.todoapp.service.TodoService;

import java.util.List;
import java.util.UUID;

@Controller
public class TodoApiController implements TodoApi {

    @Autowired
    private TodoService todoService;

    @Override
    public ResponseEntity<List<TodoDto>> getAllTodos() {
        return ResponseEntity.ok(todoService.getAllTodos());
    }

    @Override
    public ResponseEntity<TodoDto> addTodo(TodoDto newTodo) {
        return ResponseEntity.ok(todoService.addTodo(newTodo));
    }

    @Override
    public ResponseEntity<TodoDto> getTodo(UUID uuid) {
        return ResponseEntity.ok(todoService.getTodo(uuid));
    }

    @Override
    public ResponseEntity<Void> deleteTodo(UUID uuid) {
        todoService.deleteTodo(uuid);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<TodoDto> updateTodo(UUID uuid, TodoDto newTodo) {
        return ResponseEntity.ok(todoService.updateTodo(uuid, newTodo));
    }
}
