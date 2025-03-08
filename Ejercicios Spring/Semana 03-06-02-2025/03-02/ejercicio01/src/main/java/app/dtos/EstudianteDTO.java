package app.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstudianteDTO {

    @JsonProperty("estudianteNumMatr")
    private Long num_matricula;

    @JsonProperty("estudianteNombre")
    private String nombre;

    @JsonProperty("estudianteApellido")
    private String apellido;

    @JsonProperty("estudianteFechaNac")
    private LocalDate fechaNac;
}
