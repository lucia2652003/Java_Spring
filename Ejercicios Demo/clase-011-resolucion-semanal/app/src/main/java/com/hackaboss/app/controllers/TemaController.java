package com.hackaboss.app.controllers;

import com.hackaboss.app.dtos.CursoDTO;
import com.hackaboss.app.dtos.TemaDTO;
import com.hackaboss.app.services.CursoServicioInterfaz;
import com.hackaboss.app.services.TemaServicioInterfaz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/temas")
public class TemaController {

    @Autowired
    TemaServicioInterfaz servicio;

    @GetMapping({"/", ""})
    public ResponseEntity<List<TemaDTO>> buscarTema(){
        List<TemaDTO> listado = servicio.buscarTodos();
        return ResponseEntity.ok(listado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<TemaDTO>> buscarTemasDeUnCurso(@PathVariable Long id){
        List<TemaDTO> listado = servicio.buscarPorCurso(id);
        return ResponseEntity.ok(listado);
    }

    @PostMapping({"/", ""})
    public ResponseEntity<TemaDTO> crearTema(@RequestBody TemaDTO temaDTO){
        TemaDTO tema = servicio.crear(temaDTO);
        return ResponseEntity.status(201).body(tema);
    }
}
