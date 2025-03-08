package app.controllers;

import app.services.IAlumnoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nombre")
public class AlumnoController {

    IAlumnoService alumnosServiciosInterfaz;

    //Inyección de dependencia sin autocableado
    public AlumnoController(IAlumnoService alumnosServiciosInterfaz) {
        this.alumnosServiciosInterfaz = alumnosServiciosInterfaz;
    }

    //localhost:8080/nombre/
    @GetMapping({"/",""})
    public ResponseEntity<List<String>> obtenerAlumnos(){
        return ResponseEntity.status(200)
                             .header("Clave principal", "Listado de Alumnos")
                             .body(alumnosServiciosInterfaz.mostrarAlumnos());
    }

    //localhost:8080/nombre/agregar
    @PostMapping("/agregar")
    public ResponseEntity<List<String>> obtenerAlumnoPOST(@RequestBody List<String> lista){
        return ResponseEntity.status(200)
                .header("Clave principal", "Listado de Alumnos")
                .body(alumnosServiciosInterfaz.mostrarAlumnosPOST(lista));
    }
}
