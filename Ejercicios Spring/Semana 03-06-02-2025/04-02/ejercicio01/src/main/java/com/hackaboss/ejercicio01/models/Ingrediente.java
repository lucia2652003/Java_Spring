package com.hackaboss.ejercicio01.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Ingrediente {

    private Long codigoIngrediente;
    private String nombreIngrediente;
    private Double calorias;

}
