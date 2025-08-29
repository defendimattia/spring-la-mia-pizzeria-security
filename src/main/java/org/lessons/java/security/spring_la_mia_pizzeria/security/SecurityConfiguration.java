package org.lessons.java.security.spring_la_mia_pizzeria.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http)
            throws Exception {
        http.authorizeHttpRequests(requests -> requests
                .requestMatchers("/user").hasAuthority("USER")
                .requestMatchers("/pizzas/create", "/pizzas/edit").hasAuthority("ADMIN")
                .requestMatchers("/pizzas/{id}/specialoffert").hasAuthority("ADMIN")
                .requestMatchers("/ingredients/create").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "/pizzas/**", "/ingredients/create").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/pizzas/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.PATCH, "/pizzas/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/pizzas/**", "/ingredients/delete/**").hasAuthority("ADMIN")
                .requestMatchers("/pizzas", "/pizzas/**", "/ingredients").hasAnyAuthority("USER", "ADMIN")
                .requestMatchers("/").permitAll()
                .anyRequest().denyAll())
                .formLogin(Customizer.withDefaults());

        return http.build();
    }

    DaoAuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();

        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());

        return authenticationProvider;
    }

    @Bean
    DatabaseUserDetailsService userDetailsService() {
        return new DatabaseUserDetailsService();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
