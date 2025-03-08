package app.controllers;

import app.models.Alumno;
import app.services.AlumnoServiceInterfaz;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notas")
public class NotasController {

    AlumnoServiceInterfaz alumnoServiceInterfaz;

    public NotasController(AlumnoServiceInterfaz alumnoServiceInterfaz) {
        this.alumnoServiceInterfaz = alumnoServiceInterfaz;
    }

    @GetMapping({"/",""})
    public ResponseEntity obtenerNotasAlumnos(){
        List<Alumno> misAlumnos = alumnoServiceInterfaz.obtenerTodosLosAlumnos();
        return  ResponseEntity.status(200).body(misAlumnos);
    }
}
