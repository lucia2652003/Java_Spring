package app.controllers;

import app.services.IAlumnoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notas")
public class NotasController {

    IAlumnoService iAlumnoService;

    public NotasController(IAlumnoService iAlumnoService) {
        this.iAlumnoService = iAlumnoService;
    }

    //localhost:8080/notas
    @GetMapping("")
    public ResponseEntity obtenerNotasAlumnos(){
        return ResponseEntity.status(200).body(iAlumnoService.mostrarAlumnos());
    }
}
