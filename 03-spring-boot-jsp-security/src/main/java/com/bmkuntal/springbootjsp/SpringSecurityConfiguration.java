package com.bmkuntal.springbootjsp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

//    Deprecated
//    @Bean
//    public InMemoryUserDetailsManager createUserDetailsManager(){
//        UserDetails userDetails= User.withDefaultPasswordEncoder()
//                .username("user@gmail.com")
//                .password("Pass@123")
//                .roles("User", "Admin")
//                .build();
//        return new InMemoryUserDetailsManager(userDetails);
//    }

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {
        UserDetails userDetails = User.builder().passwordEncoder(input -> passwordEncoder().encode(input))
                .username("user@gmail.com")
                .password("Pass@123")
                .roles("User", "Admin")
                .build();
        return new InMemoryUserDetailsManager(userDetails);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated());

        http.formLogin(Customizer.withDefaults());
        http.headers().frameOptions().disable();

        http.csrf().disable();

        return http.build();
    }
}
