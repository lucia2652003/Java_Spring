package com.app;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppJpaApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI(){
		return  new OpenAPI().info(new Info()
				.title("API de Personas")
				.version("0.0.1")
				.description("API donde realizaremos la gestión de las personas"));
	}

}
