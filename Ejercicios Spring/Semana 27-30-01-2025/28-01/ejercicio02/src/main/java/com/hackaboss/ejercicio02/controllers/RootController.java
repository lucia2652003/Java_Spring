package com.hackaboss.ejercicio02.controllers;

import com.hackaboss.ejercicio02.utilities.Utilities;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    @GetMapping("/morse/{valor}")
    public String mostrarMorse(@PathVariable String valor){
        return Utilities.textoAMorse(valor);
    }
}
