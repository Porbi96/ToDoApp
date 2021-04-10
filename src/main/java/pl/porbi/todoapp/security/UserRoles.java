package pl.porbi.todoapp.security;

import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static pl.porbi.todoapp.security.UserPermissions.*;

@AllArgsConstructor
public enum UserRoles {
    ADMIN(Sets.newHashSet(TODO_MANAGEMENT)),
    USER(Sets.newHashSet(TODO_READ, TODO_WRITE));

    @Getter
    private final Set<UserPermissions> permissions;

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> authorities = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
