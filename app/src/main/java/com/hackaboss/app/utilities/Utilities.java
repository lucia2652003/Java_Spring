package com.hackaboss.app.utilities;

import com.hackaboss.app.models.Persona;
import com.hackaboss.app.responses.RespuestaPersona;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class Utilities {

    private List<Persona> personas;

    public Utilities() {
        this.personas = new ArrayList<>();
        personas.add(new Persona(1L, "Juan", 28));
        personas.add(new Persona(2L, "Lucia", 21));
        personas.add(new Persona(3L, "Lola", 15));
        personas.add(new Persona(4L, "Pablo", 26));
    }

    public List<Persona> findAll(){
        return this.personas;
    }

    public Persona newPersona(String nombre, int edad){
        Persona nuevo = new Persona(this.personas.size()+1L, nombre, edad);
        this.personas.add(nuevo);
        return nuevo;
    }


    public Persona findOne(Long id) {
        return this.personas.stream()
                .filter(e-> e.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public RespuestaPersona create(Persona persona){
        try {
            this.personas.add(persona);
            return new RespuestaPersona("Se ha añadido la persona", 200, "POST - OK");
        } catch (Exception e) {
            return new RespuestaPersona(e.getMessage(), 500, "POST - Error");
        }
    }

    public ResponseEntity createResponseEntity(Persona persona) {
        this.personas.add(persona);

        HttpHeaders cabecera = new HttpHeaders();
        cabecera.add("ClavePrioritaria", "Valor priritario");

        return ResponseEntity.status(HttpStatus.OK)
                             .header(cabecera.toString())
                             .body(persona);
    }
}
