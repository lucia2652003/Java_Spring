package com.hackaboss.ejercicio.utilities;

import com.hackaboss.ejercicio.entities.Evento;
import com.hackaboss.ejercicio.entities.Ponente;

import java.util.ArrayList;
import java.util.List;

public class PonenteUtilities {

    private List<Ponente> listado;

    public PonenteUtilities() {
        this.listado = new ArrayList<>();

        listado.add(new Ponente(1L, "Esteban Madrazzo"));
        listado.add(new Ponente(2L, "Lucia Blanco"));
        listado.add(new Ponente(3L, "Isabela Míñoz"));
        listado.add(new Ponente(4L, "Luis Bisbal"));
        listado.add(new Ponente(5L, "Pedro Otero"));

    }


    public Ponente findByOne(long id) {
        return this.listado.stream()
                           .filter(persona -> persona.getId() == id)
                           .findFirst()
                           .orElse(null);
    }

    public Ponente findByOneName(String nombre) {
        return this.listado.stream()
                .filter(persona -> persona.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }
}
