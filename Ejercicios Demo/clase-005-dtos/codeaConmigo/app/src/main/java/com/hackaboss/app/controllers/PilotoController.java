package com.hackaboss.app.controllers;

import com.hackaboss.app.dtos.EquipoDTO;
import com.hackaboss.app.dtos.PilotoDTO;
import com.hackaboss.app.entitites.Equipo;
import com.hackaboss.app.services.PilotoServiceInterfaz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pilotos")
public class PilotoController {

    @Autowired
    PilotoServiceInterfaz pilotoServiceInterfaz;

    @GetMapping("/traer")
    public ResponseEntity obtenerEquipos(){
        //servicio
        List<PilotoDTO> listado = pilotoServiceInterfaz.buscarPilotos();
        return ResponseEntity.status(200).body(listado);
    }

    @GetMapping("/traer/{nombre}")
    public ResponseEntity obtenerEquipoPorNombre(@PathVariable String nombre){
        //servicio
        List<PilotoDTO> pilotos = pilotoServiceInterfaz.buscarPilotosPorEquipo(nombre);
        return ResponseEntity.status(200).body(pilotos);
    }

}
