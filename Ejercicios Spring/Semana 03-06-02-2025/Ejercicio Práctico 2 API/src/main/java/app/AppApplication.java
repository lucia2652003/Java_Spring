package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
*
* Realizar una API que, a partir de brindarle una
* lista de nombres esta los ordene de forma alfabética y
* devuelva la lista ordenada en una response.
* Para la correcta resolución del ejercicio implementar
* la arquitectura multicapas en su totalidad, haciendo principal
* hincapié en la capa service (por el momento omitir model, DTO y Repository).

* ¿De qué manera desarrollarías la lógica de negocio?
* ¿Cómo harías que service implemente sus métodos? ¿Cómo el Controller podrá hacer acceso a éstos?
* */
@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

}
