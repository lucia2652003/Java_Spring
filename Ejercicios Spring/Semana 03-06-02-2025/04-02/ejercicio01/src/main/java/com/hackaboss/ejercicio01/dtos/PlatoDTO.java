package com.hackaboss.ejercicio01.dtos;

import com.hackaboss.ejercicio01.models.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor @AllArgsConstructor
public class PlatoDTO {

    private Double totalCalorias;
    private Map<String, Double> listaIngredientes;
    private Ingrediente ingredienteMax;

}
