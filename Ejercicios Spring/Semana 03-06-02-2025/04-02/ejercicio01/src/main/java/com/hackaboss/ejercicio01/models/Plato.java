package com.hackaboss.ejercicio01.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor
public class Plato {

    private Long codigoPlato;
    private String nombrePlato;
    private Double precioPlato;
    private List<Ingrediente> ingredientes;

}
