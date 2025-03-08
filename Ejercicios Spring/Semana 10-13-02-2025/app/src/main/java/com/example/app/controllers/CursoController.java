package com.example.app.controllers;

import com.example.app.dtos.CursoDTO;
import com.example.app.servicies.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    ICursoService servicio;

    //localhost:8080/cursos
    @GetMapping({"", "/"})
    public ResponseEntity<List<CursoDTO>> mostrarCursos(){
        return ResponseEntity.status(200).body(servicio.mostrarCursoInfo());
    }

    //localhost:8080/cursos
    @PostMapping({"", "/"})
    public ResponseEntity<CursoDTO> crearCurso(@RequestBody CursoDTO cursoDTO){
        return ResponseEntity.status(201)
                              .body(servicio.anhadirCurso(cursoDTO));
    }

    //localhost:8080/cursos/filtrar?palabra=Java
    @GetMapping("/filtrar")
    public ResponseEntity<List<CursoDTO>> mostrarCursosNombre(@RequestParam String nombre){
        return ResponseEntity.status(200).body(servicio.mostrarCursoNombre(nombre));
    }

    //localhost:8080/cursos/**
    @PutMapping("/{id}")
    public ResponseEntity<CursoDTO> actualizarCurso(@PathVariable Long id, @RequestBody CursoDTO cursoDTO){
        return ResponseEntity.ok(servicio.modificarCurso(id, cursoDTO));
    }
}
