package pl.porbi.todoapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import pl.porbi.todoapp.dao.UserDao;
import pl.porbi.todoapp.dao.UserRepository;

import java.util.Optional;
import java.util.Set;

import static pl.porbi.todoapp.security.UserRoles.USER;

@Component
public class MongoUserDetailsService implements UserDetailsService {

    private final UserRepository repository;

    @Autowired
    public MongoUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserDao> userDaoOptional = repository.findByUsername(username);

        if (userDaoOptional.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        UserDao userDao = userDaoOptional.get();

        return new User(userDao.getUsername(), userDao.getPassword(), userDao.getAuthorities());

    }
}
