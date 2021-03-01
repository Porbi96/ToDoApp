package pl.porbi.todoapp.mappings;

import com.github.dozermapper.core.Mapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.porbi.todoapp.dao.TodoDao;
import pl.porbi.todoapp.dto.TodoDto;

public class TodoDaoMappingTest {

    @Test
    void shouldMapTodoDaoToTodoDto() {
        Mapper mapper = MapperHelper.getMapper();

        TodoDao todoDao = new TodoDao();
        todoDao.setCompleted(false);
        todoDao.setTitle("Make dinner");

        TodoDto todoDto = mapper.map(todoDao, TodoDto.class);

        Assertions.assertEquals(todoDao.getUuid(), todoDto.getUuid());
        Assertions.assertEquals(todoDao.getTitle(), todoDto.getTitle());
        Assertions.assertEquals(todoDao.isCompleted(), todoDto.isCompleted());
    }
}
