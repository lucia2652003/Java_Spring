package app.controllers;

import app.dtos.CursoTemaDTO;
import app.services.ICursoTemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/temasCurso")
public class CursoTemaController {

    @Autowired
    ICursoTemaService service;

    //localhost:8080/temasCurso/filtrar?nombreCurso=Java Basico
    @GetMapping("/filtrar")
    public ResponseEntity<List<CursoTemaDTO>> mostrarTemasCurso(@RequestParam String nombreCurso){
        return ResponseEntity.status(200).body(service.mostrarTemasCurso(nombreCurso));
    }
}
