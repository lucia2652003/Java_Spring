package com.hackaboss.app.dtos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hackaboss.app.entities.Tema;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CursoDTO {

    private Long identificador;

    @JsonProperty("primerNombre")
    private String nombre;

    @JsonProperty("tipo")
    private String tipoCurso;

    @JsonProperty("fechaFin")
    private LocalDate fechaFinalizacion;

    @JsonManagedReference
    @JsonProperty("susTemas")
    private List<TemaDTO> temas;
}
