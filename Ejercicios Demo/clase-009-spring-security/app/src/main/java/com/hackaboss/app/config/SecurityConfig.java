package com.hackaboss.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    //metodo para que funcione como un beans de spring
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        //solicitudes POST
                    .requestMatchers(HttpMethod.POST, "/pruebasecurity/**").permitAll()
                        //solicitudes GET
                    .requestMatchers("/pruebasecurity/holanoseg").permitAll()
                    .anyRequest().authenticated())
                    .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
                    .httpBasic(httpBasic -> httpBasic.realmName("app"))
                    .build();
    }
}
