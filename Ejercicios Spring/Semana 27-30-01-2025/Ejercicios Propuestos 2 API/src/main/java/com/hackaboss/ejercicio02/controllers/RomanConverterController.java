package com.hackaboss.ejercicio02.controllers;

import com.hackaboss.ejercicio02.utilities.RomanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


//Añadir un controlador
@RestController
public class RomanConverterController {

    //http:localhost:8080/convertir/1000
    @GetMapping("/convertir/{numero}")
    public String convertir(@PathVariable int numero){
        return RomanUtils.validarNumRomano(numero);
    }
}
