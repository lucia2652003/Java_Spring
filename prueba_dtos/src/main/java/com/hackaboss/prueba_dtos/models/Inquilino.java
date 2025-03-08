package com.hackaboss.prueba_dtos.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class Inquilino {

    private  Long idInquilino;
    private String dni;
    private String nombre;
    private String apellido;
    private String profesion;

}
