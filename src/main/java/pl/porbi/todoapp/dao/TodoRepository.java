package pl.porbi.todoapp.dao;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface TodoRepository extends MongoRepository<TodoDao, ObjectId> {
    Optional<TodoDao> findByUuid(UUID uuid);
}
