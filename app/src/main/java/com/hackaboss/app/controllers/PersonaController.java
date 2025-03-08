package com.hackaboss.app.controllers;

import com.hackaboss.app.models.Persona;
import com.hackaboss.app.responses.RespuestaPersona;
import com.hackaboss.app.utilities.Utilities;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//localhost:8080/personas/       - GET
//localhost:8080/personas/nuevo  - GET
//localhost:8080/personas/5     - GET
//localhost:8080/personas/       - POST
//localhost:8080/personas/nuevo  - POST


//Añadir un controlador
@RestController
@RequestMapping("/personas")//Prefijo
public class PersonaController {

    Utilities utilsPersona = new Utilities();

    //localhost:8080/personas/       - GET
    @GetMapping("/")//Sufijo
    public List<Persona> mostrarPersonas(){
        return utilsPersona.findAll();
    }


    //localhost:8080/personas/nuevo?nombre=martin&edad=25   - GET
    @GetMapping("/nuevo")
    public Persona crearPersonas(@RequestParam String nombre, @RequestParam int edad){
        return utilsPersona.newPersona(nombre, edad);
    }

    //localhost:8080/personas/5 - GET
    @GetMapping("/{id}")
    public Persona buscarPersona(@PathVariable Long id){
        return utilsPersona.findOne(id);
    }

    //localhost:8080/personas/       - POST
    @PostMapping("/")
    public RespuestaPersona crearPersona(@RequestBody Persona persona){
        return utilsPersona.create(persona);
    }

    //localhost:8080/personas/new  - POST
    @PostMapping("/new")
    public ResponseEntity crearPersonaEntity(@RequestBody Persona persona){
        return utilsPersona.createResponseEntity(persona);
    }
}
