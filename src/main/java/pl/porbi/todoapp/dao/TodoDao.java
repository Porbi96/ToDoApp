package pl.porbi.todoapp.dao;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;

@Data
@Document("Todos")
public class TodoDao {
    @Id
    private ObjectId _id = ObjectId.get();

    @Indexed(unique = true)
    private UUID uuid = UUID.randomUUID();

    @NotBlank
    @Size(max = 300)
    private String title;

    private boolean completed = false;

    private Date creationDate = new Date();
}
