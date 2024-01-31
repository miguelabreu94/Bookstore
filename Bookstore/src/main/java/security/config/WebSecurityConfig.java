package security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Order(1)
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((auth) -> auth
                .requestMatchers("/","/admin/login","/user/login").permitAll());

        return http.build();
    }

}
