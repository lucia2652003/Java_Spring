package com.app.controllers;

import com.app.dtos.PersonaDTO;
import com.app.servicies.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    //Inyectar la dependencia de un servicio
    @Autowired
    IPersonaService servicio;

    //localhost:8080/personas
    @GetMapping({"/", ""})
    public ResponseEntity<List<PersonaDTO>> mostrarPersonas(){
        List<PersonaDTO> listado = servicio.buscarTodos();
        return ResponseEntity.status(200).body(listado);
    }

    //localhost:8080/personas
    @PostMapping({"/", ""})
    public ResponseEntity<PersonaDTO> guardarPersona(@RequestBody PersonaDTO persona){
        PersonaDTO personaCreada = servicio.crearPersona(persona);
        return ResponseEntity.status(201).body(personaCreada);
    }

    //localhost:8080/personas/1
    @GetMapping("/{id}")
    public ResponseEntity<PersonaDTO> buscarPersona(@PathVariable Long id){
        PersonaDTO encontrado = servicio.buscarPersonaId(id);
        return ResponseEntity.status(200).body(encontrado);
    }

    //localhost:8080/personas/1
    @PutMapping("/{id}")
    public ResponseEntity<PersonaDTO> actualizarPersona(@PathVariable Long id,@RequestBody PersonaDTO personaDTO){
        PersonaDTO actualizada = servicio.actualizarPersona(id, personaDTO);
        return ResponseEntity.ok(actualizada);
    }

    //localhost:8080/personas/1
    @DeleteMapping("/{id}")
    public ResponseEntity<List<PersonaDTO>> eliminarPersona(@PathVariable Long id){
        return ResponseEntity.ok(servicio.eliminarPersona(id));
    }
}
