package com.hackaboss.app.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropiedadInquilinoDTO {

    private String tipoPropiedad;
    private String direccion;
    private String nombre;
    private String profesion;
}
