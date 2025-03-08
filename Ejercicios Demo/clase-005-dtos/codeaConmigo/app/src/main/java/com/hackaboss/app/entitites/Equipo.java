package com.hackaboss.app.entitites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipo {
    private Long id;
    private String nombre;
    private String pais;
}
