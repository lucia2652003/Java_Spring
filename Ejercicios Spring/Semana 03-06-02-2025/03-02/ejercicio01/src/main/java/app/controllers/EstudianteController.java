package app.controllers;

import app.models.Estudiante;
import app.services.IEstudianteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//Recibimos peticiones HTTP y transformamos objeto JAVA e JSON
@RestController
@RequestMapping("/estudiantes")//Añadimos un prefijo
public class EstudianteController {

    //Inyección de interfaces
    IEstudianteService iEstudianteService;

    public EstudianteController(IEstudianteService iEstudianteService) {
        this.iEstudianteService = iEstudianteService;
    }

    //localhost:8080/estudiantes
    @GetMapping("")
    public ResponseEntity<List<Estudiante>> mostrarEstudiantes(){
        return ResponseEntity.status(200)
                             .header("Clave principal", "Listado Estudiantes")
                             .body(iEstudianteService.obtenerTodosEmp());
    }
}
