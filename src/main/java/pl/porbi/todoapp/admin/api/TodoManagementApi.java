package pl.porbi.todoapp.admin.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin/api/v1/todos")
public interface TodoManagementApi {

    @DeleteMapping
    ResponseEntity<Void> deleteAllTodos();
}
