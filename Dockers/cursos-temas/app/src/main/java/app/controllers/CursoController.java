package app.controllers;

import app.dtos.CursoDTO;
import app.services.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    ICursoService service;

    //localhost:8080/cursos
    @GetMapping("")
    public ResponseEntity<List<CursoDTO>> mostrarCursos(){
        List<CursoDTO> todos = service.mostrarInfo();
        return ResponseEntity.status(200).body(todos);
    }

    //localhost:8080/cursos/agregar
    @PostMapping("/agregar")
    public ResponseEntity<CursoDTO> crearCurso(@RequestBody CursoDTO cursoDTO){
        return ResponseEntity.status(201).body(service.crearCurso(cursoDTO));
    }

    //localhost:8080/cursos/filtrarNombreCurso?nombre=Java
    @GetMapping("/filtrarNombreCurso")
    public ResponseEntity<List<CursoDTO>> muestraCursoNombre(@RequestParam String nombre){
        return ResponseEntity.status(200).body(service.mostrarCursosNombre(nombre));
    }

    //localhost:8080/cursos/**
    @PutMapping("/{id}")
    public ResponseEntity<CursoDTO> actualizarCurso(@PathVariable Long id, @RequestBody CursoDTO cursoDTO){
        CursoDTO actualizado = service.actualizarCurso(id, cursoDTO);
        return  ResponseEntity.ok(actualizado);
    }
}
