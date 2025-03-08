package com.hackaboss.app.controllers;

import com.hackaboss.app.dtos.CursoDTO;
import com.hackaboss.app.services.CursoServicioInterfaz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    CursoServicioInterfaz servicio;

    //localhost:8080/cursos?nombre=java
    @GetMapping({"/", ""})
    public ResponseEntity<List<CursoDTO>> buscarCursos(@RequestParam(required = false) String nombre){
        List<CursoDTO> listado = servicio.buscarCursosPorNombre(nombre);
        return ResponseEntity.ok(listado);
    }

    @PostMapping({"/", ""})
    public ResponseEntity<CursoDTO> crear(@RequestBody CursoDTO cursoDTO){
        CursoDTO cursoGuardado = servicio.crear(cursoDTO);
        return ResponseEntity.status(201).body(cursoGuardado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoDTO> actualizar(@PathVariable Long id, @RequestBody CursoDTO cursoDTO){
        CursoDTO cursoActualizado = servicio.actualizar(id, cursoDTO);
        return ResponseEntity.status(200).body(cursoActualizado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDTO> buscarTemasDeUnCurso(@PathVariable Long id){
        CursoDTO cursoEncontrado = servicio.buscarPorCurso(id);
        return ResponseEntity.ok(cursoEncontrado);
    }
}
