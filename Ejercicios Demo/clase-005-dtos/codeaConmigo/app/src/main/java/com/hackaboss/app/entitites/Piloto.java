package com.hackaboss.app.entitites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Piloto {

    private Long id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String nacionalidad;
    private List<Equipo> equipos;


}
