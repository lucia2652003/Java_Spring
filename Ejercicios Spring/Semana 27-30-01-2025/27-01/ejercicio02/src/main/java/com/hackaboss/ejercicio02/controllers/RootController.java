package com.hackaboss.ejercicio02.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class RootController {
    //Desde el navegador localhost:8080
    @GetMapping("/")
    public String mostrarDatoCurioso(){
        List<String> informacion = new ArrayList<>();

        informacion.add("Los delfines tienen la capacidad de reconocer y recordar estos silbidos específicos incluso después de mucho tiempo");
        informacion.add("Las hormigas son capaces de llevar objetos que son hasta 50 veces su propio peso");
        informacion.add("Los tiburones pueden llegar a vivir entre 70 y 100 años");
        informacion.add("Los cisnes son los más hermosos sus plumas blancas y su largo cuello le dotan de estilo y elegancia");
        informacion.add("Las ballenas azules son los más grandes del mundo, pueden pesar hasta 180 toneladas y medir hasta 30 metros de largo");
        informacion.add("Los elefantes son capaces de producir ruidos infrasónicos para comunicarse con otros de su especie");

        Random random = new Random();
        int numAlzar = random.nextInt(informacion.size()); //Número aleatorio

        return informacion.get(numAlzar);//Mostrar el dato
    }
}
