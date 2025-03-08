package com.hackaboss.carreraAutos.controllers;

import com.hackaboss.carreraAutos.models.Piloto;
import com.hackaboss.carreraAutos.services.IPilotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pilotos")
public class PilotoController {

    @Autowired
    private IPilotoService iPilotoService;

    //localhost:8080/pilotos/traer
    @GetMapping("/traer")
    public ResponseEntity<List<Piloto>> mostrarPilotos(){
        return ResponseEntity.status(200)
                .body(iPilotoService.mostrarInfoPilotos());
    }

    //localhost:8080/pilotos/traer/{nombre_equipo}
    @GetMapping("/traer/{nombre_equipo}")
    public ResponseEntity mostrarInfoPiloto(@PathVariable String nombre_equipo){
        return ResponseEntity.status(200)
                .body(iPilotoService.mostrarPilotosEquipo(nombre_equipo));
    }

    //localhost:8080/pilotos/agregar
    @PostMapping("/agregar")
    public ResponseEntity agregarPiloto(@RequestBody Piloto piloto){
        return ResponseEntity.status(201)
                .body(iPilotoService.agregarPiloto(piloto));
    }
}
