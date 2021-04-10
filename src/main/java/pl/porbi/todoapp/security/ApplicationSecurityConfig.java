package pl.porbi.todoapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.porbi.todoapp.service.MongoUserDetailsService;

import static pl.porbi.todoapp.security.UserPermissions.TODO_MANAGEMENT;
import static pl.porbi.todoapp.security.UserRoles.ADMIN;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

//    private PasswordEncoder passwordEncoder;

    final
    MongoUserDetailsService userDetailsService;

    @Autowired
    public ApplicationSecurityConfig(MongoUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                    .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
                    .antMatchers(HttpMethod.DELETE, "/admin/**").hasRole(ADMIN.name())
                    .antMatchers("/admin/**").hasAnyAuthority(TODO_MANAGEMENT.getPermission()) // order matters!
                    .anyRequest().authenticated()
                .and()
//                .formLogin(); // form based auth
                .httpBasic() // basic auth
                .and()
                .sessionManagement().disable();
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userDetailsService);
    }

    //    @Override
//    @Bean
//    protected UserDetailsService userDetailsService() {
//        UserDetails porbiUser = User.builder()
//                .username("Porbi")
//                .password(passwordEncoder.encode("1234"))
////                .roles(USER.name())
//                .authorities(USER.getGrantedAuthorities())
//                .build();
//
//        UserDetails porbiAdminUser = User.builder()
//                .username("PorbiAdmin")
//                .password(passwordEncoder.encode("1234"))
////                .roles(ADMIN.name())
//                .authorities(ADMIN.getGrantedAuthorities())
//                .build();
//
//        return new InMemoryUserDetailsManager(
//                porbiAdminUser,
//                porbiUser
//        );
//    }
}
