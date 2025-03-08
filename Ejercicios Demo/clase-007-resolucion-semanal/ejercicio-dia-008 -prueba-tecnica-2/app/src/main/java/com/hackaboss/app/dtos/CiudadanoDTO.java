package com.hackaboss.app.dtos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hackaboss.app.entities.Turno;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class CiudadanoDTO {

    private Long identificador;

    @JsonProperty("primerNombre")
    private String nombre;

    @JsonProperty("primerApellido")
    private String apellido;

    @JsonProperty("correo")
    private String email;

    @JsonManagedReference
    @JsonProperty("susTurnos")
    private List<TurnoDTO> turnos;
}
