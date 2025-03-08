package app.controllers;

import app.models.Alumno;
import app.services.IAlumnoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    IAlumnoService alumnosServiciosInterfaz;

    //Inyección de dependencia sin autocableado
    public AlumnoController(IAlumnoService alumnosServiciosInterfaz) {
        this.alumnosServiciosInterfaz = alumnosServiciosInterfaz;
    }

    //localhost:8080/alumnos/
    @GetMapping({"/",""})
    public ResponseEntity<List<Alumno>> obtenerAlumnos(){
        return ResponseEntity.status(200).body(alumnosServiciosInterfaz.mostrarAlumnos());
    }

    //localhost:8080/alumnos/agregar
    @PostMapping("/agregar")
    public ResponseEntity<String> crearAlumnos(@RequestBody Alumno alumno){
        alumnosServiciosInterfaz.crearAlumnos(alumno);
        return ResponseEntity.status(201).body("Se ha guardado con éxito");
    }
}
