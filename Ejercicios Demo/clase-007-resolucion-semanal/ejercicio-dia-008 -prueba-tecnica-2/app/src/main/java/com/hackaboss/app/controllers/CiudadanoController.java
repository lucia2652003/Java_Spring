package com.hackaboss.app.controllers;

import com.hackaboss.app.dtos.CiudadanoDTO;
import com.hackaboss.app.services.CiudadanoServicioInterfaz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ciudadanos")
public class CiudadanoController {

    @Autowired
    CiudadanoServicioInterfaz servicio;

    @GetMapping({"/",""})
    public ResponseEntity<List<CiudadanoDTO>> buscarCiudadano(){
        //servicio
        List<CiudadanoDTO> listado = servicio.buscarTodos();
        return ResponseEntity.ok(listado);
    }

    @GetMapping("/filtrarPor")
    public ResponseEntity<CiudadanoDTO> buscarCiudadanoEmail(@RequestParam String email){
        //servicio
        CiudadanoDTO turnoEncontrado = servicio.buscarPorEmail(email);
        return ResponseEntity.ok(turnoEncontrado);
    }

    @PostMapping({"/",""})
    public ResponseEntity<CiudadanoDTO> crearCiudadanos(@RequestBody CiudadanoDTO ciudadanoDTO){
        //servicio
        CiudadanoDTO turnoGuardado = servicio.crear(ciudadanoDTO);
        return ResponseEntity.ok(turnoGuardado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CiudadanoDTO> actualizarCiudadanos(@PathVariable Long id, @RequestBody CiudadanoDTO ciudadanoDTO){
        //servicio
        CiudadanoDTO turnoActualizado = servicio.actualizar(id, ciudadanoDTO);
        return ResponseEntity.ok(turnoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<CiudadanoDTO>> eliminarCiudadanos(@PathVariable Long id){
        //servicio
        List<CiudadanoDTO> listado = servicio.eliminar(id);
        return ResponseEntity.ok(listado);
    }
}
