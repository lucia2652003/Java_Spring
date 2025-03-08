package com.example.app.dtos;

import com.example.app.entities.Curso;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor
public class CursoDTO {

    @JsonIgnore
    @JsonProperty("codigoCurso")
    private Long id_curso;

    @JsonProperty("nombreCurso")
    private String nombre;

    @JsonProperty("tipoCurso")
    private Curso.TipoCurso tipo;

    @JsonProperty("fechaFinalizacion")
    private LocalDate fecha;


}
