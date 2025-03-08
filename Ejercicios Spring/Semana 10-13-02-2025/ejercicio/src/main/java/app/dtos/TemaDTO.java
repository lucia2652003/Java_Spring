package app.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TemaDTO {

    private Long identifTema;

    @JsonProperty("titulo")
    private String nombre;

    @JsonProperty("comentario")
    private String descripcion;

    @JsonProperty("codigoCurso")
    private Long curso_asociado;
}
