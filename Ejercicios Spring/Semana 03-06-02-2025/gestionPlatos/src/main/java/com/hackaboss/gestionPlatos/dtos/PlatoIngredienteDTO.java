package com.hackaboss.gestionPlatos.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlatoIngredienteDTO {

    private String nombrePlato;
    private Boolean celiaco;
}
