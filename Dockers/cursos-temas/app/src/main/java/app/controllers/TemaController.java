package app.controllers;

import app.dtos.TemaDTO;
import app.services.ITemaService;
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
    @GetMapping("")
    public ResponseEntity<List<TemaDTO>> mostrarTodoTema(){
        return ResponseEntity.status(200).body(service.mostrarInfoTemas());
    }

    //localhost:8080/temas/agregar
    @PostMapping("/agregar")
    public ResponseEntity<TemaDTO> crearTema(@RequestBody TemaDTO temaDTO){
        return ResponseEntity.status(201).body(service.ingresarTema(temaDTO));
    }

    //localhost:8080/temas/id
    @PutMapping("/{id}")
    public ResponseEntity<TemaDTO> actualizarTema(@PathVariable Long id, @RequestBody TemaDTO temaDTO){
        return ResponseEntity.ok(service.actualizarTema(id, temaDTO));
    }
}
