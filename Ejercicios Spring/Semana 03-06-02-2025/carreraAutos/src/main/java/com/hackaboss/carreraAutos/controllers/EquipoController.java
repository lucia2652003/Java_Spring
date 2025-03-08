package com.hackaboss.carreraAutos.controllers;

import com.hackaboss.carreraAutos.models.Equipo;
import com.hackaboss.carreraAutos.services.EquipoService;
import com.hackaboss.carreraAutos.services.IEquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/equipos")
public class EquipoController {

    @Autowired
    private IEquipoService iEquipoService;

    //localhost:8080/equipos/traer
    @GetMapping("/traer")
    public ResponseEntity mostrarEquipos(){
        return ResponseEntity.status(200).body(iEquipoService.obtenerInfoEquipos());
    }

    //localhost:8080/equipos/traer/{nombre_equipo}
    @GetMapping("/traer/{nombre_equipo}")
    public ResponseEntity buscarEquipo(@PathVariable String nombre_equipo){
        Equipo buscado = iEquipoService.buscarEquipo(nombre_equipo);

        if(buscado == null) return ResponseEntity.status(404)
                .body("No se ha podido encontrar ese equipo");

        else return ResponseEntity.status(200)
                     .body(buscado);
    }

    //localhost:8080/equipos/agregar
    @PostMapping("/agregar")
    public ResponseEntity agregarEquipo(@RequestBody Equipo equipo){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(iEquipoService.agregarEquipo(equipo));
    }
}
