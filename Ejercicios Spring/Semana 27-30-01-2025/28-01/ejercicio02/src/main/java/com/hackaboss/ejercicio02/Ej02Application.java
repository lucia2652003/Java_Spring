package com.hackaboss.ejercicio02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
*
* El sistema Morse permite cifrar cada grafema del alfabeto
* como una secuencia de "puntos" y "rayas" o “líneas”. Por ejemplo, la letra S se cifra como · · ·,
* la letra T se cifra como − y el número 7 se cifra como · · - - -

* El código Morse no hace diferencia entre mayúsculas y minúsculas,
* sin embargo sus conversiones comúnmente se presentan en letras en mayúscula
* (por convención). Al redactar el mensaje un código Morse, se utiliza un
*  solo espacio para separar los códigos de grafemas y se emplean 3 espacios para separar palabras.

* En base a esto, realizar una API que sea capaz de descifrar
* SOLO PALABRAS (no frases) de nuestro alfabeto a código morse.
* Para ello, el sistema deberá tener en cuenta la siguiente tabla de valores de conversión:
*
*
* */
@SpringBootApplication
public class Ej02Application {

	public static void main(String[] args) {
		SpringApplication.run(Ej02Application.class, args);
	}

}
