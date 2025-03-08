package com.hackaboss.gestionPlatos.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ingrediente {

    private Long idIngrediente;
    private String nombreIngrediente;

    //true: es celiaco, false: no
    private Boolean celiaco;

}
