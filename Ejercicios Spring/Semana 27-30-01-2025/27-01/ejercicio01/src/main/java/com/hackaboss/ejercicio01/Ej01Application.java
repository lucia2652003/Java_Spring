package com.hackaboss.ejercicio01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
*
* Crear un programa que, al acceder a localhost:8080 a través de
* un navegador mediante el método GET,
* devuelva un refrán aleatorio de una lista predefinida.
* Por ejemplo: “No hay mal que por bien no venga”,
* “Al que madruga Dios lo ayuda”, etc.
*
* */
@SpringBootApplication
public class Ej01Application {

	public static void main(String[] args) {
		SpringApplication.run(Ej01Application.class, args);
	}

}
