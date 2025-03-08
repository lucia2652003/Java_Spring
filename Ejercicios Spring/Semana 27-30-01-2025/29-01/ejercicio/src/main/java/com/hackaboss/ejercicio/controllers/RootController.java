package com.hackaboss.ejercicio.controllers;

import com.hackaboss.ejercicio.entities.Evento;
import com.hackaboss.ejercicio.utilities.EventoUtilities;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//localhost:8080/eventos   - GET
//localhost:8080/evento/id - GET
//localhost:8080/evento    - POST

//Añadir un controlador
@RestController
@RequestMapping("")
public class RootController {

    EventoUtilities utilsEventos = new EventoUtilities();

    //localhost:8080/eventos   - GET
    @GetMapping("/eventos")//Añadir un sufijo
    public List<Evento> mostrarEventos(){
        return utilsEventos.obtenerInfo();
    }

    //localhost:8080/evento/id - GET
    @GetMapping("/evento/{id}")//Añadir un sufijo
    public Evento mostrarEvento(@PathVariable long id){
        return utilsEventos.findByOne(id);
    }
    //localhost:8080/evento    - POST
    @PostMapping("/evento")
    public ResponseEntity crearEvento(@RequestBody Evento evento){
        return utilsEventos.create(evento);
    }
}
