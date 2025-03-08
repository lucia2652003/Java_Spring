package com.hackaboss.app.controllers;

import com.hackaboss.app.entities.Platillo;
import com.hackaboss.app.utilities.MenuUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menu")
public class MenuController {

    MenuUtils menuUtils = new MenuUtils();
    @GetMapping({"/",""})
    public ResponseEntity obtenerRecurso(@RequestParam(required = false) String tipoMenu){
        return menuUtils.findAll(tipoMenu);
    }

    @PostMapping("/agregar")
    public ResponseEntity agregarRecurso(@RequestBody Platillo platillo){
        return menuUtils.createPlatillo(platillo);
    }
}
