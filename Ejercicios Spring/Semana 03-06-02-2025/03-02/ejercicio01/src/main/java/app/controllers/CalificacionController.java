package app.controllers;

import app.models.Calificacion;
import app.services.ICalificacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * Crear una API que gestione los datos de estudiantes de una universidad y que devuelva una
 * lista ordenada de acuerdo con su rendimiento académico en la materia “Programación I” (calculado en forma de promedio).
 * Implementar para esto una arquitectura de múltiples capas, destacando la capa service, para procesar y analizar los datos
 * de los estudiantes.
 * Enfocarse en la lógica de negocio para evaluar el rendimiento académico, pudiendo involucrar la capa model para representar los datos de los estudiantes.
 *
 *
 * De cada estudiante se solicitan los siguientes datos: num_matricula, nombre, apellido, fecha de nacimiento.
 *
 * Para las calificaciones se necesita una clase Calificacion, la cual almacena las 3 calificaciones que
 * obtuvo cada estudiante en los exámenes de la materia “Programación I” y su promedio.
 * Tener en cuenta que cada estudiante tiene uno y solo un registro de calificaciones asociado.
 *
 * En la clase calificación se debe guardar: id, calificacion1, calificacion2, calificacion3, promedio, Alumno un Alumno.
 *
 * En la capa controller deberán existir los siguientes endpoints:
 *
 * GET /estudiantes: Devuelve una lista de todos los estudiantes sin un orden particular.
 * GET /calificaciones/{num_matricula}: Devuelve las calificaciones de un determinado estudiante.
 * GET /calificaciones/ordendesc: Devuelve las calificaciones de todos los estudiantes,
 *     junto con el nombre de cada uno de ellos
 * ordenados de forma descendente (mayor calificación primero, menor a lo último)
 *
 * */
@RestController
@RequestMapping("/calificaciones")
public class CalificacionController {

    ICalificacionService iCalificacionService;

    public CalificacionController(ICalificacionService iCalificacionService) {
        this.iCalificacionService = iCalificacionService;
    }

    //localhost:8080/calificaciones/{num_matricula}
    @GetMapping("/{num_matricula}")
    public ResponseEntity buscarCalificacion(@PathVariable Long num_matricula){
        if(num_matricula == 0){
            return ResponseEntity.status(404).body("Debes introducir una matricula");
        }

        Calificacion calificacion = iCalificacionService.buscarCalificacion(num_matricula);
        if(calificacion == null) return ResponseEntity.status(404).body("El estudiante no existe");
        else return ResponseEntity.status(200).body(calificacion);
    }

    //localhost:8080/calificaciones/ordendesc
    @GetMapping("/ordendesc")
    public ResponseEntity mostrarCalificacion(){
        return ResponseEntity.status(200).body(iCalificacionService.mostrarCalificacionOrdDesc());
    }
}
