package com.example.app.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TemaDTO {

    @JsonIgnore
    @JsonProperty("codigoTema")
    private Long identificadorTema;

    private String titulo;

    @JsonProperty("detalles")
    private String descripcion;

    @JsonProperty("curso_asociado")
    private Long identificadorCurso;
}
