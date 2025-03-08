package com.example.app.controller;

import com.example.app.dtos.ReservaDTO;
import com.example.app.servicies.IReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    IReservaService servicio;

    //localhost:8080/reservas
    @GetMapping({"/", ""})
    public ResponseEntity<List<ReservaDTO>> mostrarReservas(){
        return ResponseEntity.status(200).body(servicio.mostrarInfoReservas());
    }

    //localhost:8080/reservas/agregar
    @PostMapping("/agregar")
    public ResponseEntity<ReservaDTO> agregarReserva(@RequestBody ReservaDTO reservaDTO){
        return ResponseEntity.status(201).body(servicio.crearReserva(reservaDTO));
    }

    //localhost:8080/reservas/filtrar?fechaInicio=2025-02-18T15:30:17&fechaFin=2025-08-12T17:25:00
    @GetMapping("/filtrar")
    public ResponseEntity<List<ReservaDTO>> mostrarReservaFechas(@RequestParam LocalDateTime fechaInicio, @RequestParam LocalDateTime fechaFin){
        return ResponseEntity.ok(servicio.mostrarReservasFechas(fechaInicio, fechaFin));
    }

    //localhost:8080/reservas/id
    @GetMapping("/{id}")
    public ResponseEntity<ReservaDTO> mostrarReserva(@PathVariable Long id){
        return ResponseEntity.ok(servicio.buscarReserva(id));
    }

    //localhost:8080/reservas/id
    @PutMapping("/{id}")
    public ResponseEntity<ReservaDTO> actualizarReserva(@PathVariable Long id,@RequestBody ReservaDTO reservaDTO){
        return ResponseEntity.ok(servicio.modificarReserva(id, reservaDTO));
    }

}
