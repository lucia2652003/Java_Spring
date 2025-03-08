package com.hackaboss.pedidos.controllers;

import com.hackaboss.pedidos.models.Plato;
import com.hackaboss.pedidos.responses.RespuestaPlato;
import com.hackaboss.pedidos.utilities.MenuUtilities;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//localhost:8080/menu?tipoMenu=vegetariano  - GET
//localhost:8080/menu/agregar               - POST

//Añadir un controlador
@RestController
@RequestMapping("/menu")
public class MenuController {

    MenuUtilities utils = new MenuUtilities();

    //localhost:8080/menu?tipoMenu=vegetariano  - GET
    @GetMapping("")
    public ResponseEntity mostrarMenus(@RequestParam String tipoMenu){
        return utils.filtrarMenus(tipoMenu);
    }

    //localhost:8080/menu/agregar               - POST
    @PostMapping("/agregar")
    public RespuestaPlato agregarPlato(@RequestBody Plato plato){
        return utils.agregarPlato(plato);
    }

}
