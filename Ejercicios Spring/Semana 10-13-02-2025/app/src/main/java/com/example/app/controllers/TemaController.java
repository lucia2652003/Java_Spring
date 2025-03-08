package com.example.app.controllers;

import com.example.app.dtos.TemaDTO;
import com.example.app.servicies.ITemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/temas")
public class TemaController {

    @Autowired
    ITemaService service;

    //localhost:8080/temas
    @PostMapping({"", "/"})
    public ResponseEntity<TemaDTO> insertarTema(@RequestBody TemaDTO temaDTO){
        return ResponseEntity.status(201).body(service.crearTema(temaDTO));
    }

    //localhost:8080/temas/filtrarNombreCurso?curso=Java avanzado
    @GetMapping("/filtrarNombreCurso")
    public ResponseEntity<List<TemaDTO>> mostrarTemasCurso(@RequestParam String curso){
        return ResponseEntity.status(200).body(service.mostrarTemasCurso(curso));
    }

    //localhost:8080/temas/**
    @PutMapping("/{id}")
    public ResponseEntity<TemaDTO> modificarTema(@PathVariable Long id, @RequestBody TemaDTO temaDTO){
        return ResponseEntity.ok(service.actualizarTema(id, temaDTO));
    }
}
