package com.hackaboss.app.dtos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hackaboss.app.entities.Curso;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TemaDTO {

    private Long identificador;

    @JsonProperty("titulo")
    private String nombre;

    @JsonProperty("detalles")
    private String descripcion;

    @JsonBackReference
    @JsonProperty("cursoId")
    private CursoDTO curso;

    @JsonProperty("curso")
    private String cursoNombre;
}


