package app.controllers;

import app.dtos.TurnoCiudadanoDTO;
import app.servicies.ITurnoCiudadanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/listadoTurnos")
public class TurnoCiudadanoController {

    @Autowired
    ITurnoCiudadanoService servicio;

    //localhost:8080/listadoTurnos
    @GetMapping("")
    public ResponseEntity<List<TurnoCiudadanoDTO>> mostrarTurnos(){
        return ResponseEntity.ok(servicio.mostrarInfo());
    }

    //localhost:8080/listadoTurnos/filtro?fecha=2025-02-05&estado=ESPERA
    @GetMapping("/filtro")
    public ResponseEntity<List<TurnoCiudadanoDTO>> mostrarTurnoFiltro(@RequestParam LocalDate fecha, @RequestParam String estado){
        return ResponseEntity.ok(servicio.obtenerTurnosFiltro(fecha, estado));
    }
}
