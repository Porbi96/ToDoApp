package pl.porbi.todoapp.dao;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends MongoRepository<UserDao, ObjectId> {
    Optional<UserDao> findByUuid(UUID uuid);
    Optional<UserDao> findByUsername(String username);
}
