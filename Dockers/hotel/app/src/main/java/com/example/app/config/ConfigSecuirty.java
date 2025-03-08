package com.example.app.config;

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
public class ConfigSecuirty {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        //Todos los métodos que empiecen por / no requieren de autenticación, salvo los POST
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorized->
                        authorized.requestMatchers(HttpMethod.DELETE, "/**").permitAll()
                                  .requestMatchers(HttpMethod.GET, "/**").permitAll()
                                  .requestMatchers(HttpMethod.PUT, "/**").permitAll()
                                  .requestMatchers("/documentacion").permitAll().anyRequest().authenticated()
                )
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
                .httpBasic(http-> http.realmName("app"))
                .build();
    }
}
