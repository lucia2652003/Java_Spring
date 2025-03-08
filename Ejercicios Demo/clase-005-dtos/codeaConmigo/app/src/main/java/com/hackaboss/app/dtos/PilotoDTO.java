package com.hackaboss.app.dtos;

import com.hackaboss.app.entitites.Equipo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PilotoDTO {

    private String nombre;
    private String apellido;
    private List<Equipo> equipo;
}
