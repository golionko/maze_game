package com.game.maze.security;

import com.game.maze.persist.entity.User;
import com.game.maze.persist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private WebApplicationContext applicationContext;
    private UserRepository userRepository;

    public CustomUserDetailsService() {
        super();
    }

    @PostConstruct
    public void completeSetup() {
        userRepository = applicationContext.getBean(UserRepository.class);
    }

    @Override
    public UserDetails loadUserByUsername(final String username) {
        final User appUser = userRepository.findByUserName(username).orElseThrow(() ->
                new UsernameNotFoundException("User not found with username: " + username)
        );
        return UserPrincipal.create(appUser);
    }

    public UserDetails loadUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found for id: " + id)
        );

        return UserPrincipal.create(user);
    }
}