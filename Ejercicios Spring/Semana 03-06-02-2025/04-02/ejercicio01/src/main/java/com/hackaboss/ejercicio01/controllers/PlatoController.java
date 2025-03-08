package com.hackaboss.ejercicio01.controllers;

import com.hackaboss.ejercicio01.dtos.PlatoDTO;
import com.hackaboss.ejercicio01.servicies.IPlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurante")
public class PlatoController {

    @Autowired
    private IPlatoService iPlatoService;


    //localhost:8080/restaurante/{nombre_plato}
    @GetMapping("/{nombre_plato}")
    public ResponseEntity mostrarPlato(@PathVariable String nombre_plato){
        return ResponseEntity.status(200).body(iPlatoService.buscarPlato(nombre_plato));
    }
}
