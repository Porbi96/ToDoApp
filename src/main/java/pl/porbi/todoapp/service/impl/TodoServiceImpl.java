package pl.porbi.todoapp.service.impl;

import com.github.dozermapper.core.Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import pl.porbi.todoapp.dao.TodoDao;
import pl.porbi.todoapp.dao.TodoRepository;
import pl.porbi.todoapp.dto.TodoDto;
import pl.porbi.todoapp.service.TodoService;
import pl.porbi.todoapp.utils.exceptions.NoSuchElementInDatabaseException;

import java.util.*;

@Service
@Slf4j
public class TodoServiceImpl implements TodoService {

    @Autowired
    Mapper mapper;

    @Autowired
    TodoRepository todoRepository;

    @Override
    public List<TodoDto> getAllTodos() {
        List<TodoDao> todoDaos = todoRepository.findAll();
        List<TodoDto> todoDtos = new ArrayList<>();
        todoDaos.forEach(todoDao -> todoDtos.add(mapper.map(todoDao, TodoDto.class)));
        return todoDtos;
    }

    @Override
    public TodoDto getTodo(UUID uuid) {
        log.trace("Getting todo note by id: {}", uuid);
        TodoDao todo = todoRepository.findByUuid(uuid).orElseThrow(NoSuchElementInDatabaseException::new);
        return mapper.map(todo, TodoDto.class);
    }

    @Override
    public TodoDto addTodo(TodoDto todoDto) {
        TodoDao todoDao = new TodoDao();
        todoDao.setTitle(todoDto.getTitle());
        todoDao.setCompleted(todoDto.isCompleted());
        todoRepository.save(todoDao);
        return getTodo(todoDao.getUuid());
    }

    @Override
    public void deleteTodo(UUID uuid) {
        TodoDao todo = todoRepository.findByUuid(uuid).orElseThrow(NoSuchElementInDatabaseException::new);
        todoRepository.delete(todo);
    }

    @Override
    public TodoDto updateTodo(UUID uuid, TodoDto newTodo) {
        TodoDao todo = todoRepository.findByUuid(uuid).orElseThrow(NoSuchElementInDatabaseException::new);
        todo.setTitle(newTodo.getTitle());
        todo.setCompleted(newTodo.isCompleted());
        todoRepository.save(todo);
        return getTodo(todo.getUuid());
    }
}
