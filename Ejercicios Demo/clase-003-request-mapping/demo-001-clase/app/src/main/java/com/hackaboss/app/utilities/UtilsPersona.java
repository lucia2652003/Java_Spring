package com.hackaboss.app.utilities;

import com.hackaboss.app.models.Persona;
import com.hackaboss.app.responses.RespuestaPersona;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class UtilsPersona {

    private List<Persona> personas;

    public UtilsPersona() {
        this.personas = new ArrayList<>();
        personas.add(new Persona(1L, "Juan Perez", 31));
        personas.add(new Persona(2L, "Maria Perez", 32));
        personas.add(new Persona(3L, "Andres Perez", 33));
        personas.add(new Persona(4L, "Paula Perez", 34));
        personas.add(new Persona(5L, "Brian Perez", 35));
    }

    public List<Persona> findAll(){
        return this.personas;
    }

    public Persona newPersona(String nombre, int edad){
        Persona nuevaPersona = new Persona(this.personas.size()+1L, nombre, edad);
        this.personas.add(nuevaPersona);
        return nuevaPersona;
    }

    public Persona findOne(Long id) {
        return this.personas.stream()
                .filter(persona -> persona.getId()
                        .equals(id)).findFirst().get();
    }

    public RespuestaPersona create(Persona persona) {
        try{
            this.personas.add(persona);
            return new RespuestaPersona("Usuario Creado con Exito", 200,"POST - OK");
        } catch (Exception e) {
            return new RespuestaPersona(e.getMessage(), 500,"POST - Error");
        }

    }

    public ResponseEntity createResponseEntity(Persona persona) {

        this.personas.add(persona);

        HttpHeaders headers = new HttpHeaders();
        headers.add("pass", "kfgdfg45df45df45gf");
        return ResponseEntity
                            .status(HttpStatus.CREATED)
                            .headers(headers)
                            .body(new RespuestaPersona("Persona Guardada con exito", 201, "POST - 201"));
    }
}
