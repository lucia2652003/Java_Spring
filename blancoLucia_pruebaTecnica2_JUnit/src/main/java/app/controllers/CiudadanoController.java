package app.controllers;

import app.dtos.CiudadanoDTO;
import app.servicies.ICiudadanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ciudadanos")
public class CiudadanoController {

    @Autowired
    ICiudadanoService iCiudadanoService;

    //localhost:8080/ciudadanos
    @PostMapping({"/", ""})
    public ResponseEntity<List<CiudadanoDTO>> agregarCiudadano(@RequestBody CiudadanoDTO ciudadanoDTO){
        return ResponseEntity.status(201).body(iCiudadanoService.crearCiudadano(ciudadanoDTO));
    }

    //localhost:8080/ciudadanos
    @GetMapping({"/", ""})
    public ResponseEntity obtenerInfoCiudadanos(){
        return ResponseEntity.status(200).body(iCiudadanoService.mostrarCiudadanos());
    }

    //localhost:8080/ciudadanos/id
    @GetMapping("{id}")
    public ResponseEntity<CiudadanoDTO> mostrarCiudadano(@PathVariable Long id){
        return ResponseEntity.ok(iCiudadanoService.buscarCiudadano(id));
    }

    //localhost:8080/ciudadanos/id
    @PutMapping("{id}")
    public ResponseEntity<CiudadanoDTO> actualizarCiudadano(@PathVariable Long id, @RequestBody CiudadanoDTO entidad){
        return ResponseEntity.ok(iCiudadanoService.actualizar(id, entidad));
    }

    //localhost:8080/ciudadanos/id
    @DeleteMapping("{id}")
    public ResponseEntity<List<CiudadanoDTO>> eliminarCiudadano(@PathVariable Long id){
        return ResponseEntity.ok(iCiudadanoService.eliminar(id));
    }
}
