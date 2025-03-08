package com.hackaboss.app.controllers;

import com.hackaboss.app.utilities.RootUtility;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RootController {

    //localhost:8080/frases
    @GetMapping("/frases")
    public String frasesAleatorias(){
        List<String> listado = RootUtility.recuperarListadoDeFrases();
        return RootUtility.obtenerElementoRandom(listado);
    }

    //localhost:8080/frases
    @GetMapping("/datos")
    public String datosCuriosos(){
        List<String> listado = RootUtility.recuperarListadoDeDatos();
        return RootUtility.obtenerElementoRandom(listado);
    }
}
