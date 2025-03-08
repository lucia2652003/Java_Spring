package com.hackaboss.ejercicio01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
*
* Llevar a cabo una API mediante SpringBoot donde a partir de que
* se envíe el nombre de una persona mediante URL, la API responda
* un “Hola Mundo” + el nombre que se envío como parámetro.

* Agregar un segundo parámetro edad y hacer un endpoint que si
* recibe nombre + edad muestre el “Hola Mundo” + nombre + edad.

* Agregar un tercer parámetro que sea profesión y crear
* otro endpoint que si recibe nombre + edad + profesión muestre
*  “Hola mundo” + nombre + edad + profesión.
*
* Pruebas que puedes realizar para probar la API:
*
* /saludar?nombre=Juan devolverá "Hola Mundo Juan".
* /saludarConEdad?nombre=María&edad=25 devolverá "Hola Mundo María tienes 25 años".
* /saludarConProfesion?nombre=Pedro&edad=30&profesion=Ingeniero devolverá "Hola Mundo Pedro tienes 30 años y eres Ingeniero".
*
* */
@SpringBootApplication
public class Ej01Application {

	public static void main(String[] args) {
		SpringApplication.run(Ej01Application.class, args);
	}

}
