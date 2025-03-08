package com.hackaboss.carreraAutos.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor
@NoArgsConstructor
public class Equipo {
    private Long idEquipo;
    private String nombreEquipo;
    private String pais;
}
