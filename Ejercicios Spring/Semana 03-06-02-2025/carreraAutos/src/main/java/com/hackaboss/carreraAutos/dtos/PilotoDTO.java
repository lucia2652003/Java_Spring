package com.hackaboss.carreraAutos.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PilotoDTO {

    @JsonProperty("Nombre_Completo_Piloto")
    private String nombreComPiloto; //Nombre completo del Piloto, nombrePiloto + apellidoPiloto
    @JsonProperty("Nombre_Equipo")
    private String nombreEquipo;
}
