package app.controllers;

import app.services.OrdenServiceInterfaz;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ordenamiento")
public class OrdenamientoController {

    /*Inyeccion*/
    OrdenServiceInterfaz interfaz;

    public OrdenamientoController(OrdenServiceInterfaz interfaz) {
        this.interfaz = interfaz;
    }

    @PostMapping("/nombre")
    public ResponseEntity ordenamientoNombre(@RequestBody List<String> listaNombres){
        List<String> listadoOrdenado = interfaz.ordenamientoNombre(listaNombres);
        return ResponseEntity.status(200).body(listadoOrdenado);
    }
}
