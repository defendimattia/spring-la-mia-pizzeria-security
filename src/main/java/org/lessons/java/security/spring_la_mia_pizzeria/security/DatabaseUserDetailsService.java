package org.lessons.java.security.spring_la_mia_pizzeria.security;

import java.util.Optional;

import org.lessons.java.security.spring_la_mia_pizzeria.model.User;
import org.lessons.java.security.spring_la_mia_pizzeria.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DatabaseUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> userTry = userRepository.findByUsername(username);
        if (userTry.isEmpty()) {
            throw new UsernameNotFoundException("Username not found");
        }

        return new DatabaseUserDetails(userTry.get());
    }
}
