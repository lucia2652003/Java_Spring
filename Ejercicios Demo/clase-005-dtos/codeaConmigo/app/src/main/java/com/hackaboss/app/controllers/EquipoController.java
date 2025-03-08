package com.hackaboss.app.controllers;

import com.hackaboss.app.dtos.EquipoDTO;
import com.hackaboss.app.entitites.Equipo;
import com.hackaboss.app.services.EquipoServiceInterfaz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/equipos")
public class EquipoController {

    @Autowired
    EquipoServiceInterfaz equipoServiceInterfaz;

    @GetMapping("/traer")
    public ResponseEntity obtenerEquipos(){
        //servicio
        List<Equipo> listado = equipoServiceInterfaz.buscarEquiposInscritos();
        return ResponseEntity.status(200).body(listado);
    }

    @GetMapping("/traer/{nombre}")
    public ResponseEntity obtenerEquipoPorNombre(@PathVariable String nombre){
        //servicio
        EquipoDTO equipo = equipoServiceInterfaz.buscarEquipoPorNombre(nombre);
        return ResponseEntity.status(200).body(equipo);
    }
}
