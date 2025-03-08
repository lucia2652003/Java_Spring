package com.hackaboss.app.controllers;

import com.hackaboss.app.models.UsuarioRespuesta;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    //http:localhost:8080/saludar/brian
    @GetMapping("/saludar/{nombre}")
    public String saludarConNombre(@PathVariable String nombre){
        return  "Hola mundo " + nombre;
    }

    //http:localhost:8080/saludar?nombre=brian
    @GetMapping("/saludar")
    public String saludarConNombreQS(@RequestParam String nombre){
        return "Hola queryString de nombre es: " + nombre;
    }

    //http:localhost:8080/saludarConEdad?nombre=brian&edad=30
    @GetMapping("/saludarConEdad")
    public String saludarConNombreEdad(@RequestParam String nombre, @RequestParam int edad){
        return "Hola mundo " + nombre + " y tengo " + edad + " años.";
    }

    //http:localhost:8080/saludarConProfesion?nombre=brian&edad=30&profesion=profesor
    @GetMapping("/saludarConProfesion")
    public String saludarConNombreEdadProfesion(@RequestParam String nombre, @RequestParam int edad, @RequestParam String profesion){
        return "Hola " + profesion + " " + nombre + " y el tiene " + edad + " años.";
    }

    //http:localhost:8080/saludarConJSON/brian
    @GetMapping("/saludarConJSON/{nombre}")
    public UsuarioRespuesta saludarConJSON(@PathVariable String nombre){
        UsuarioRespuesta res = new UsuarioRespuesta();
        res.setPrametroRecibido(nombre);
        res.setPrametroEnviado("Saludos " + nombre + ", esta respuesta es con un JSON");
        res.setStatus("OK - 200");

        System.err.println(res.getStatus());
        return res;
    }
}
