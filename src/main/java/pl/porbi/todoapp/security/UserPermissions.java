package pl.porbi.todoapp.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum UserPermissions {
    TODO_READ("todo:read"),
    TODO_WRITE("todo:write"),
    TODO_MANAGEMENT("todo:management");

    @Getter
    private final String permission;
}
