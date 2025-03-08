package com.hackaboss.carreraAutos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
*En una competencia de carreras de autos, se tiene una lista de equipos participantes en donde +
* cada equipo cuenta con uno o varios pilotos.
* Como dato extra, un mismo piloto puede pertenecer a diferentes equipos siempre y cuando sean del mismo país.

* Para administrar esta información, se requiere una aplicación que conste de dos clases principales:

* Equipo, con los atributos:
* ID
* Nombre
* País

* Piloto, con los atributos:
* ID
* Nombre
* Apellido
* Edad
* Nacionalidad


* La organización de las carreras necesita una API que permita realizar las siguientes consultas:
*   i. Ver todos los equipos inscritos en la competencia: localhost:8080/equipos/traer
*   ii. Ver todos los pilotos registrados en la competencia: localhost:8080/pilotos/traer
*   iii. Obtener un equipo en particular: localhost:8080/equipos/traer/{nombre_equipo}
*   iv. Obtener todos los pilotos que formen parte de un equipo en específico: localhost:8080/pilotos/traer/{nombre_equipo}

* Para esta respuesta se debe utilizar el patrón DTO,
* incluyendo únicamente como dato nombre y apellido del piloto
* y el nombre del equipo al que pertenece (que debe coincidir con el equipo consultado).

* Además, para cargar nuevos equipos y pilotos, se solicita la creación de un endpoint que permita,
* mediante el método POST, recibir objetos de equipos y pilotos para almacenarlos en una lista.

* Esta lista es la que se utilizará como “base de datos lógica” y se consultará para devolver los datos solicitados
* en los puntos anteriores.
*
* */
@SpringBootApplication
public class CarreraAutosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarreraAutosApplication.class, args);
	}

}
