package app.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoTemaDTO {

    @JsonProperty("codigoTema")
    private Long idTema;

    @JsonProperty("tituloTema")
    private String nombreTema;

    @JsonProperty("comentarioTema")
    private String descripcionTema;

    @JsonProperty("nombreCurso")
    private String curso;
}
