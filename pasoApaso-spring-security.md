# Implementación de Spring Security en un proyecto Spring Boot

## Introducción
Este documento describe los pasos necesarios para implementar Spring Security en una aplicación desarrollada con Spring Boot. 

---

## Paso 1: Añadir dependencias

1. Ve a [Spring Initializr](https://start.spring.io/) y genera un nuevo proyecto seleccionando las siguientes dependencias:
   - **Spring Web**
   - **Spring Security**

2. Descarga el proyecto generado y ábrelo en tu IDE favorito.

3. Chequea que tengas `spring-boot-starter-security` como dependencia.

---

## Paso 2: Crear controladores

Crea un paquete controllers y agrega un controllador llamado `HolaController` con dos endpoints: uno protegido por seguridad y otro accesible sin autenticación.

```java
package com.ejercicios.springSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pruebasecurity")
public class HolaController {

    @GetMapping("/holaseg")
    public String holaMundoSeguro() {
        return "Hola mundo con seguridad";
    }

    @GetMapping("/holanoseg")
    public String holaMundoNoSeguro() {
        return "Hola mundo sin seguridad";
    }
}
```

---

## Paso 3: Configurar Spring Security

1. Crea un paquete llamado `config` y dentro de él, una clase `SecurityConfig` con la configuración necesaria para personalizar los filtros de seguridad.

```java
package com.ejercicios.springSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/pruebasecurity/holanoseg").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form.permitAll())
                .build();
    }

}
```

2. Esta configuración:
   - Permite el acceso sin autenticación al endpoint `/pruebasecurity/holanoseg`.
   - Requiere autenticación para cualquier otro endpoint.
   - Habilita un formulario de inicio de sesión predeterminado.

---

## Paso 4: Probar la aplicación

1. Inicia la aplicación.
2. Intenta acceder a los siguientes endpoints:
   - `http://localhost:8080/pruebasecurity/holanoseg`: No debería requerir autenticación.
   - `http://localhost:8080/pruebasecurity/holaseg`: Debería redirigirte al formulario de inicio de sesión.

Por defecto, las credenciales son:
- **Usuario**: `user`
- **Contraseña**: Generada automáticamente y visible en la consola de tu aplicación al iniciarla.

---

## Paso 5: Personalizar usuario y contraseña

En el archivo `application.properties`, puedes establecer un usuario y contraseña personalizados:

```properties
spring.security.user.name=usuarioPersonalizado
spring.security.user.password=contraseñaPersonalizada
```

⚠ **Nota**: No almacenes credenciales directamente en este archivo en entornos de producción. Usa variables de entorno u opciones más seguras.

---

## Paso Extra: Cerrar sesión

Para cerrar la sesión del usuario, simplemente accede a la URL `/logout`. Esto invalidará la sesión actual y será necesario autenticarse nuevamente para acceder a los endpoints protegidos.

---

## Conclusión
Con estos pasos, has implementado Spring Security en tu aplicación Spring Boot. Puedes personalizar esta configuración según las necesidades específicas de tu proyecto.
