package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
*
* Crear una API que gestione los datos de estudiantes de una universidad y que devuelva una
* lista ordenada de acuerdo con su rendimiento
* académico en la materia “Programación I” (calculado en forma de promedio).
* Implementar para esto una arquitectura de múltiples capas, destacando la capa service,
* para procesar y analizar los datos de los estudiantes.

* Enfocarse en la lógica de negocio para evaluar el rendimiento académico,
* pudiendo involucrar la capa model para representar los datos de los estudiantes.
*       De cada estudiante se solicitan los siguientes datos:
*                     num_matricula, nombre, apellido, fecha de nacimiento.

* Para las calificaciones se necesita una clase Calificacion,
* la cual almacena las 3 calificaciones que obtuvo cada estudiante en los
* exámenes de la materia “Programación I” y su promedio.
* Tener en cuenta que cada estudiante tiene uno y solo un registro de calificaciones asociado.
*
* En la clase calificación se debe guardar:
*     id, calificacion1, calificacion2, calificacion3, promedio, Alumno un Alumno.


* En la capa controller deberán existir los siguientes endpoints:
*   GET /estudiantes: Devuelve una lista de todos los estudiantes sin un orden particular.
*   GET /calificaciones/{num_matricula}: Devuelve las calificaciones de un determinado estudiante.
*   GET /calificaciones/ordendesc: Devuelve las calificaciones de todos los estudiantes,
*        junto con el nombre de cada uno de ellos ordenados de forma descendente
*        (mayor calificación primero, menor a lo último)
*
* */
@SpringBootApplication
public class Ejercicio01Application {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio01Application.class, args);
	}

}
