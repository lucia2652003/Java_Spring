package com.example.ejercicio.controllers;

import com.example.ejercicio.dtos.AutoDTO;
import com.example.ejercicio.services.IAutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * Una concesionaria de automóviles desea realizar un API REST que
 * le permita realizar la carga de determinados autos usados. Para ello, necesitamos
 * desarrollar los siguientes endpoints:
 *
 * api/vehicles/        POST     Agrega un nuevo automóvil.
 * api/vehicles/        GET      Retorna un listado de todos los autos seleccionados.
 * api/vehicles/prices  GET      Muestra el listado de los vehículos según los precios (de menor a mayor).
 * api/vehicles/{id}    GET      Muestra toda la información de un auto en particular.
 *
 */

@RestController
@RequestMapping("/api/vehicles")
public class AutoController {

    @Autowired
    IAutoService servicio;

    //localhost:8080/api/vehicles/
    @GetMapping("/")
    public ResponseEntity<List<AutoDTO>> mostrarAutos(){
        return ResponseEntity.status(200).body(servicio.mostrarInfoAutos());
    }

    //localhost:8080/api/vehicles/
    @PostMapping("/")
    public ResponseEntity<AutoDTO> crearAuto(@RequestBody AutoDTO autoDTO){
        return ResponseEntity.status(201).body(servicio.crear(autoDTO));
    }

    //localhost:8080/api/vehicles/prices
    @GetMapping("/prices")
    public ResponseEntity<List<AutoDTO>> ordenarAutosPrecios(){
        return ResponseEntity.ok(servicio.mostrarAutosOrdenPrecio());
    }
    //localhost:8080/api/vehicles/1
    @GetMapping("/{id}")
    public ResponseEntity<AutoDTO> buscarAuto(@PathVariable Long id){
        return ResponseEntity.ok(servicio.buscarAutoID(id));
    }
}
