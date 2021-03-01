package pl.porbi.todoapp.admin.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.porbi.todoapp.dto.TodoDto;

import java.util.List;

@RequestMapping("/admin/api/v1/todos")
public interface TodoManagementApi {

    @DeleteMapping
    ResponseEntity<Void> deleteAllTodos();

    @GetMapping
    ResponseEntity<List<TodoDto>> getAllTodos();
}
