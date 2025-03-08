package com.hackaboss.gestionPlatos.controllers;

import com.hackaboss.gestionPlatos.servicies.IPlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reposteria")
public class PlatoController {

    //Inyección de dependencias
    @Autowired
    private IPlatoService iPlatoService;

    //localhost:8080/reposteria/id
    @GetMapping("/{id}")
    public ResponseEntity mostrarPlato(@PathVariable Long id){
        return ResponseEntity.status(200).body(iPlatoService.mostrarPlato(id));
    }
}
