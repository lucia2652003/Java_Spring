package app.dtos;

import app.entities.Curso;
import app.entities.Tema;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoDTO {

    @JsonProperty("codigoCurso")
    @JsonIgnore
    private Long identificadorCurso;

    @JsonProperty("nombreCurso")
    private String nombre;

    @JsonProperty("tipoCurso")
    private Curso.TipoCurso tipo;

    @JsonProperty("fechaFinal")
    private LocalDate fecha;

}
