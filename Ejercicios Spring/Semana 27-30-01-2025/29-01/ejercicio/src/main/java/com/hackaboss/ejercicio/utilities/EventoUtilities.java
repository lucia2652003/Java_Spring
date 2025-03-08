package com.hackaboss.ejercicio.utilities;

import com.hackaboss.ejercicio.entities.Evento;
import com.hackaboss.ejercicio.entities.Ponente;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventoUtilities {

    private List<Evento> listadoEventos;


    public EventoUtilities() {
        this.listadoEventos = new ArrayList<>();

        PonenteUtilities ponenteUtilities = new PonenteUtilities();

        listadoEventos.add(new Evento(1L, "Conferencia de Ciencias Computacionales",
                "Una conferencia sobre los avances en inteligencia artificial y aprendizaje automático.",
                           LocalDate.of(2023, 12,15),
                          "10:00",
                "Aula Magna Centro del Conocimiento", ponenteUtilities.findByOne(1L).getNombre()));

    }

    public List<Evento> obtenerInfo() {
        return this.listadoEventos;
    }

    public Evento findByOne(long id) {
        return this.listadoEventos.stream()
                .filter(evento -> evento.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public ResponseEntity create(Evento evento) {
        evento.setId(this.listadoEventos.size()+1L);//Crear automáticamente el ID

        PonenteUtilities ponentes = new PonenteUtilities();
       /* Ponente buscado = ponentes.findByOneName(evento.getPonente());
        evento.setPonente(buscado.getNombre());*/

        this.listadoEventos.add(evento);//Actualizar la colección
        return ResponseEntity.status(201).body(this.listadoEventos);
    }
}
