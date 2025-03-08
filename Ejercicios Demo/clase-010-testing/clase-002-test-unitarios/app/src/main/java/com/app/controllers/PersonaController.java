package com.app.controllers;

import com.app.dtos.PersonaDTO;
import com.app.services.PersonaServicioInterfaz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    //intectar la dependencia de un servicio
    @Autowired
    PersonaServicioInterfaz service;

    @GetMapping({"/", ""})
    public ResponseEntity<List<PersonaDTO>> obtenerTodasLasPersonas(){
        List<PersonaDTO> listado = service.buscarTodos();
        return ResponseEntity.status(200).body(listado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonaDTO> obtenerPersonaPorID(@PathVariable Long id){
        PersonaDTO personaEncontrada = service.buscarPorId(id);
        return ResponseEntity.status(200).body(personaEncontrada);
    }

    @PostMapping({"/", ""})
    public ResponseEntity<PersonaDTO> guardarPersona(@RequestBody PersonaDTO personaDTO){
        //servicio
        PersonaDTO personaEncontrada = service.crear(personaDTO);
        return ResponseEntity.status(201).body(personaEncontrada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonaDTO> actualizarPersona(@PathVariable Long id ,@RequestBody PersonaDTO personaDTO){
        PersonaDTO personaActualizada = service.actualizar(id, personaDTO);
        return ResponseEntity.ok(personaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<PersonaDTO>> eliminarPersona(@PathVariable Long id){
        List<PersonaDTO> listado = service.eliminar(id);
        return ResponseEntity.ok(listado);
    }






}
