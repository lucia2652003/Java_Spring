package com.hackaboss.app.controllers;

import com.hackaboss.app.dtos.TurnoDTO;
import com.hackaboss.app.services.TurnoServicioInterfaz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    TurnoServicioInterfaz servicio;

    @GetMapping({"/",""})
    public ResponseEntity<List<TurnoDTO>> buscarTurnos(){
        //servicio
        List<TurnoDTO> listado = servicio.buscarTodos();
        return ResponseEntity.ok(listado);
    }

    @GetMapping("/filtrarPor")
    public ResponseEntity<List<TurnoDTO>> buscarTurnosPorFecha(@RequestParam LocalDate fecha){ //2025-02-02T14:20:20
        //servicio
        List<TurnoDTO> turnosEncontrado = servicio.buscarTodos(fecha.atStartOfDay());
        return ResponseEntity.ok(turnosEncontrado);
    }

    @GetMapping("/{idTurnero}")
    public ResponseEntity<TurnoDTO> buscarTurnosPorId(@PathVariable long idTurnero){
        //servicio
        TurnoDTO turnoEncontrado = servicio.buscarPorTurneroId(idTurnero);
        return ResponseEntity.ok(turnoEncontrado);
    }

    @PostMapping({"/",""})
    public ResponseEntity<TurnoDTO> crearTurnos(@RequestBody TurnoDTO turnoDTO){
        //servicio
        TurnoDTO turnoGuardado = servicio.crear(turnoDTO);
        return ResponseEntity.ok(turnoGuardado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TurnoDTO> actualizarTurnos(@PathVariable Long id, @RequestBody TurnoDTO turnoDTO){
        //servicio
        TurnoDTO turnoActualizado = servicio.actualizar(id, turnoDTO);
        return ResponseEntity.ok(turnoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<TurnoDTO>> eliminarTurnos(@PathVariable Long id){
        //servicio
        List<TurnoDTO> listado = servicio.eliminar(id);
        return ResponseEntity.ok(listado);
    }
}
