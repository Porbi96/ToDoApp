package pl.porbi.todoapp.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.UUID;

@Data
public class TodoDto {
    private UUID uuid;
    private String title;
    private boolean completed;
}
