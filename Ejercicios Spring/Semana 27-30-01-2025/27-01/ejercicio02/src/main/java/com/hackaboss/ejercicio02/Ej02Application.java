package com.hackaboss.ejercicio02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
*
* Crear un programa que, al acceder a localhost:8080 a
* través de un navegador mediante el método GET, devuelva un
* dato curioso de forma aleatoria de una lista que esté predefinida.

* Por ejemplo: “Los delfines tienen la capacidad de reconocer
* y recordar estos silbidos específicos incluso después de mucho tiempo”,
* “Las hormigas son capaces de llevar objetos que son hasta 50 veces su
* propio peso”, etc.
*
* */
@SpringBootApplication
public class Ej02Application {

	public static void main(String[] args) {
		SpringApplication.run(Ej02Application.class, args);
	}

}
