package com.hackaboss.app.controllers;

import com.hackaboss.app.models.Persona;
import com.hackaboss.app.responses.RespuestaPersona;
import com.hackaboss.app.utilities.UtilsPersona;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//localhost:8080/personas/          - GET
//localhost:8080/personas/nuevo     - GET
//localhost:8080/personas/5         - GET
//localhost:8080/personas/          - POST
//localhost:8080/personas/nuevo     - POST


@RestController
@RequestMapping("/personas")
public class PersonaController {

    UtilsPersona utilsPersona = new UtilsPersona();

    @GetMapping({"/", ""})
    public List<Persona> obtenerTodasLasPersonas(){
        return utilsPersona.findAll();
    }

    @GetMapping("/nuevo")
    public Persona crearPersona(@RequestParam String nombre, @RequestParam int edad){
        return utilsPersona.newPersona(nombre, edad);
    }

    @GetMapping("/{id}")
    public Persona buscarUnaPersona(@PathVariable Long id){
        return utilsPersona.findOne(id);
    }

    @PostMapping({"/", ""})
    public RespuestaPersona crearPersona(@RequestBody Persona persona){
        return utilsPersona.create(persona);
    }

    @PostMapping("/new")
    public ResponseEntity crearPersonaEntity(@RequestBody Persona persona){
        return utilsPersona.createResponseEntity(persona);
    }


}
