package com.hackaboss.app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pruebasecurity")
public class RootController {

    @GetMapping("/holaseg")
    public String holaMundoSeguro(){
        return "Hola mundo con seguridad";
    }

    // ruta protegida = /pruebasecurity/holanoseg
    @GetMapping("/holanoseg")
    public String holaMundoSinSeguro(){
        return "Hola mundo sin seguridad";
    }

    @PostMapping("/post")
    public String holaMundoSinSeguroPost(){
        return "Hola mundo sin seguridad desde una peticion POST";
    }
}
