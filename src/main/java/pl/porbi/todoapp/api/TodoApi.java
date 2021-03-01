package pl.porbi.todoapp.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.porbi.todoapp.dto.TodoDto;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/todos")
public interface TodoApi {

    @GetMapping
    ResponseEntity<List<TodoDto>> getAllTodos();

    @PostMapping
    ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto newTodo);

    @GetMapping("/{uuid}")
    ResponseEntity<TodoDto> getTodo(@PathVariable(value = "uuid") UUID uuid);

    @DeleteMapping("/{uuid}")
    ResponseEntity<Void> deleteTodo(@PathVariable(value = "uuid") UUID uuid);

    @PutMapping("/{uuid}")
    ResponseEntity<TodoDto> updateTodo(@PathVariable(value = "uuid") UUID uuid, @RequestBody TodoDto newTodo);
}
