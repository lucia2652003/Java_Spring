package com.hackaboss.app.controllers;

import com.hackaboss.app.utilities.ConvertirdorMorseUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    @GetMapping("/convertir")
    public String convertir(@RequestParam("centimetros") double cm){
        // convertir el dato de cm a metros
        int porCien = 100;
        double metros = cm/ porCien;
        return "El equivalente a " + cm + " cm en metros es de " + metros + " metros";
    }

    @GetMapping("/morse")
    public String calveMorse(@RequestParam("clave") String key){
        return ConvertirdorMorseUtils.textoAMorse(key);
    }
}
