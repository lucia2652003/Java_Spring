package com.hackaboss.ejercicio01.controller;

import com.hackaboss.ejercicio01.utilities.Utilities;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    //http:localhost:8080/conversor/163
    @GetMapping("/conversor/{centimetros}")
    public String mostrarMetros(@PathVariable int centimetros){
        return Utilities.conversorCMaM(centimetros);
    }
}
