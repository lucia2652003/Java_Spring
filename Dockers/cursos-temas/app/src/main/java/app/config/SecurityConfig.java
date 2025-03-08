package app.config;

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
        //En la URL no permite la autenticación y el resto si
        return httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests( authorized->authorized
                        //SOLICITUD POST
                        .requestMatchers(HttpMethod.POST, "/cursos/agregar", "/temas/agregar").permitAll()
                        //SOLICITUD GET
                        .requestMatchers(HttpMethod.GET, "/**").permitAll()
                        //Autenticación
                        .requestMatchers("/doc").permitAll().anyRequest().authenticated()
                )
                .httpBasic( httpBasic-> httpBasic.realmName("API Cursos"))
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
                .build();
    }
}
