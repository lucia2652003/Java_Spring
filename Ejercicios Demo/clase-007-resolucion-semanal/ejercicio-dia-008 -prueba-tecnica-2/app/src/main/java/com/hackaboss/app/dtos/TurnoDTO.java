package com.hackaboss.app.dtos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TurnoDTO {

    @JsonIgnore
    private Long identificador;

    @JsonProperty("turnoEstado")
    private String estadoTurno;

    @JsonProperty("fechaDiaTurno")
    private LocalDateTime fechaHoraTurno;

    @JsonProperty("turneroId")
    private Long codigoTurno;

    @JsonBackReference
    @JsonProperty("ciudadanoId")
    private CiudadanoDTO idCiudadano;
}
