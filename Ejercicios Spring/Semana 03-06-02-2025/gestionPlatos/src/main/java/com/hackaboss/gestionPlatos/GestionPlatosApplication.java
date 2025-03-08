package com.hackaboss.gestionPlatos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
*
* Una repostera posee una gran cantidad de clientes que son celíacos,
* para quienes realiza diferentes viandas semanales.

* Para poder mejorar su trabajo, necesita del desarrollo de una API
* que le permita cargar los diferentes platos que hace por semana
* (7 en total) y asociar a cada plato sus ingredientes.

* De los platos se guardan los siguientes datos: id, nombre plato, precio, lista ingredientes
* De los ingredientes se guarda: id, nombre ingrediente, apto celiaco

* A partir de eso, la repostera necesita poder consultar a la API por un plato
* mediante su id y recibir como respuesta el nombre del mismo
* y si es apto o no para celíacos (la aptitud se determina analizando sus ingredientes,
* si al menos uno no es apto para celíacos, el platillo ya no es apto).
* Para llevar a cabo esto, implementar el patrón de diseño DTO para permitir
* como respuesta (response) obtener únicamente como dato el
* nombre del plato consultado y si es apto o no.
*
* */
@SpringBootApplication
public class GestionPlatosApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionPlatosApplication.class, args);
	}

}
