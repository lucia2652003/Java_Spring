package com.app.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class PersonaDTO {

    private Long identificador;

    @JsonProperty("primerNombre")
    private String nombre;

    @JsonProperty("primerApellido")
    private String apellido;

    @JsonProperty("anhos")
    private Integer edad;
}
