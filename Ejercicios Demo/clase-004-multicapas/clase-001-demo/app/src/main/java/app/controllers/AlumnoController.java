package app.controllers;


import app.models.Alumno;
import app.services.AlumnoServiceInterfaz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    AlumnoServiceInterfaz alumnoServiceInterfaz;

    //Inyeccion de dependencia sin autocableado
    public AlumnoController(AlumnoServiceInterfaz alumnoServiceInterfaz) {
        this.alumnoServiceInterfaz = alumnoServiceInterfaz;
    }

    @GetMapping({"/",""})
    public ResponseEntity obtenerTodosLosAlumnos(){
        List<Alumno> listado = alumnoServiceInterfaz.obtenerTodosLosAlumnos();
        return ResponseEntity.status(200).body(listado);
    }

    @PostMapping("/agregar")
    public ResponseEntity<String> crearAlumno(@RequestBody Alumno alumno){
        alumnoServiceInterfaz.crearAlumno(alumno);
        return ResponseEntity.status(201).body("Se guardo con exito");
    }
}
