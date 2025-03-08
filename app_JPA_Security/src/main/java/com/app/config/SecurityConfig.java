package com.app.config;

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

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                                        //SOLICITUD DELETE
                                        .requestMatchers(HttpMethod.DELETE, "/personas/{id}").permitAll()
                                         //SOLICITUD PUT
                                         .requestMatchers(HttpMethod.PUT, "/personas/{id}").permitAll()
                                        //SOLICITUD POST
                                        .requestMatchers(HttpMethod.POST,"/personas").permitAll().anyRequest().authenticated()
                                        )
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
                .httpBasic(httpBasic-> httpBasic.realmName("API PERSONAS"))
                .build();
    }

}
