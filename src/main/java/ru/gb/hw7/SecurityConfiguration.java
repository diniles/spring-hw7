package ru.gb.hw7;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
@AllArgsConstructor
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests((req) -> req
                        .requestMatchers("/register").permitAll()
                        .anyRequest().authenticated())
                .formLogin((form) -> form.loginPage("/login").permitAll())
                .logout((logout) -> logout.permitAll());
        return httpSecurity.build();
    }
}
