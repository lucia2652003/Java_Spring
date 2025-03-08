package com.hackaboss.prueba_dtos.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropiedadInquilinoDTO {

    private String tipoPropiedad;
    private String direccion;
    private Double valorAlquiler;
    private String nombreInquilino;
    private String apellidoInquilino;
}
