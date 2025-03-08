package app.controllers;

import app.dtos.TurnoDTO;
import app.servicies.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    ITurnoService servicio;

    //localhost:8080/turnos
    @GetMapping({"/",""})
    public ResponseEntity<List<TurnoDTO>> obtenerTurnos(){
        return ResponseEntity.status(200).body(servicio.mostrarTurnos());
    }

    //localhost:8080/turnos
    @PostMapping({"/",""})
    public ResponseEntity<TurnoDTO> agregarTurno(@RequestBody TurnoDTO turnoDTO){
        return ResponseEntity.status(201).body(servicio.crearTurno(turnoDTO));
    }

    //localhost:8080/turnos/1
    @GetMapping("/{id}")
    public ResponseEntity<TurnoDTO> buscarTurno(@PathVariable Long id){
        TurnoDTO encontrado = servicio.buscarTurnoID(id);
        return ResponseEntity.status(200).body(encontrado);
    }

    //localhost:8080/turnos/1
    @PutMapping("/{id}")
    public ResponseEntity<TurnoDTO> actualizarTurno(@PathVariable Long id, @RequestBody TurnoDTO turnoDTO){
        TurnoDTO encontrado = servicio.actualizar(id, turnoDTO);
        return ResponseEntity.status(200).body(encontrado);
    }

    //localhost:8080/turnos/1
    @DeleteMapping("/{id}")
    public ResponseEntity<List<TurnoDTO>> eliminarTurno(@PathVariable Long id){
        return ResponseEntity.ok(servicio.eliminar(id));
    }
}
