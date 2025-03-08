package com.hackaboss.gestionPlatos.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor @AllArgsConstructor
public class Plato {

    private Long id;
    private String nombrePlato;
    private Float precio;
    private List<Ingrediente> ingredientes;

}
