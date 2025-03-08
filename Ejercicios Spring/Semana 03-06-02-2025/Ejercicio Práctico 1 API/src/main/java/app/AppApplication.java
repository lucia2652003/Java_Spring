package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
* Supongamos que tenemos un sistema de alumnos como los ejemplos
* anteriores que estuvimos viendo y que queremos implementar la arquitectura multicapas
* con la correspondiente estructura de paquetes… ¿Cómo lo harías?
*
*
* */
@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

}
