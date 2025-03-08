package com.hackaboss.ejercicio01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
* Un restaurante necesita una API que proporcione información detallada sobre las
* calorías de los platos de su menú.
* Para esto, almacena en una base de datos lógica los siguientes datos:

* Platos: codigo_plato, nombre, precio, lista_Ingredientes
* Ingredientes: codigo_ingrediente, nombre, cantidad_calorias

* La API debe recibir el nombre de un plato como parámetro y devolver en base a esto:
*    La cantidad total de calorías del plato completo.
*    Una lista de ingredientes que componen el plato, junto con la cantidad de calorías de cada uno
*    (la sumatoria de estas calorías deberían de dar la cantidad total de calorías del plato).
*    El ingrediente con la mayor cantidad de calorías en el plato.
*
* * */
@SpringBootApplication
public class Ejercicio01Application {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio01Application.class, args);
	}

}
