package pl.porbi.todoapp.dao;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;
import java.util.UUID;

import static pl.porbi.todoapp.security.UserRoles.USER;

@Data
@Document("Users")
public class UserDao {

    @Id
    private ObjectId _id = ObjectId.get();

    @Indexed(unique = true)
    private UUID uuid = UUID.randomUUID();

    @NotBlank
    @Size(max = 50)
    private String username;

    @NotBlank
    private String password;

    private Set<SimpleGrantedAuthority> authorities = USER.getGrantedAuthorities();
}
