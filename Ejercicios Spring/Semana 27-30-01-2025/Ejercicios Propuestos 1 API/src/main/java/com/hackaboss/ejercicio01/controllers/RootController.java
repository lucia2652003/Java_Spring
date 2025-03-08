package com.hackaboss.ejercicio01.controllers;

import com.hackaboss.ejercicio01.models.UsuarioRespuesta;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


//Añadir un controlador
@RestController
public class RootController {

    //http:localhost:8080/saludar/nombre
    @GetMapping("/saludar/{nombre}")
    public String saludar(@PathVariable String nombre){
        return "Hola Mundo "+nombre;
    }

    //http:localhost:8080/saludarConNombre?nombre=____
    @GetMapping("/saludar")
    public String saludarConNombre(@RequestParam String nombre){
        return "Hola Mundo "+nombre;
    }

    //http:localhost:8080/saludarConEdad?nombre=____&edad=__
    @GetMapping("/saludarConEdad")
    public String saludarConEdad(@RequestParam String nombre, @RequestParam int edad){
        return "Hola Mundo "+nombre+ " tienes "+ edad+ " años";
    }

    //http:localhost:8080/saludarConProfesion?nombre=____&edad=__&profesion=___
    @GetMapping("/saludarConProfesion")
    public String saludarConProfesion(@RequestParam String nombre, @RequestParam int edad, @RequestParam String profesion){
        return "Hola Mundo "+nombre+ " tienes "+ edad+ " años y eres "+profesion;
    }

    //http:localhost:8080/saludarConJSON/nombre
    @GetMapping("/saludarConJSON/{nombre}")
    public UsuarioRespuesta slaudarConJSON(@PathVariable String nombre){
        UsuarioRespuesta res = new UsuarioRespuesta();
        res.setParametroRecibido(nombre);
        res.setParametroEnviado("Saludos "+nombre +", esta respuesta es con un JSON");
        res.setStatus("OK - 200");

        System.err.println(res.getStatus());
        return res;
    }
}
