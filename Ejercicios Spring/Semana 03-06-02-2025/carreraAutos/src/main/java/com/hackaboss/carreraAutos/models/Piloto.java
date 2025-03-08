package com.hackaboss.carreraAutos.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Piloto {
    private Long idPiloto;
    private String nombrePiloto;
    private String apellidoPiloto;
    private Integer edad;
    private String nacionalidad;
}
