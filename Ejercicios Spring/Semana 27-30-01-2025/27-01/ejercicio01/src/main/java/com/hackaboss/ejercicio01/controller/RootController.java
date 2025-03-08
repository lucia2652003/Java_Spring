package com.hackaboss.ejercicio01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class RootController {

    //Desde el navegador localhost:8080
    @GetMapping
    public String mostrarRefran(){
        List<String> refranes = new ArrayList<>();

        refranes.add("No hay mal que por bien no venga");
        refranes.add( "Al que madruga Dios lo ayuda");
        refranes.add("Perro ladrador, poco mordedor");
        refranes.add("A la tercera va la vencida");
        refranes.add("Sin valor no hay gloria");
        refranes.add("A caballo regalado, no le mires los dientes");

        Random random = new Random();
        int numAlzar = random.nextInt(refranes.size()); //Número aleatorio

        return refranes.get(numAlzar);
    }
}
