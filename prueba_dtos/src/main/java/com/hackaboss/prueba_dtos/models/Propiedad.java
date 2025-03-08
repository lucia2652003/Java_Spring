package com.hackaboss.prueba_dtos.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class Propiedad {

    private Long idPropiedad;
    private String tipoPropiedad;
    private String direccion;
    private Double metrosCuadrados;
    private Double valorAlquiler;

}
