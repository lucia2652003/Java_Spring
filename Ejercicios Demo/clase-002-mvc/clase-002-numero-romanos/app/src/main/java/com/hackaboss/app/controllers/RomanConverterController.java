package com.hackaboss.app.controllers;

import com.hackaboss.app.utilities.RomanUtilis;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanConverterController {

    //http:localhost:8080/convertir/100
    @GetMapping("/convertir/{numerDecimal}")
    public String convertir(@PathVariable int numerDecimal){
        return RomanUtilis.validarNumeroRomano(numerDecimal);
    }
}
