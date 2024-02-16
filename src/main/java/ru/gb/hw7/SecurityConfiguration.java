package ru.gb.hw7;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests((req) -> req
                        .requestMatchers("/register/**", "/h2-console/**").permitAll()
                        .anyRequest().authenticated())
                .formLogin((form) -> form.loginPage("/login").permitAll()).sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS).invalidSessionUrl("/loginForm?invalidSession"))
                .headers(h -> h.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))

                .logout((logout) -> logout.permitAll());
        return httpSecurity.build();
    }
}
