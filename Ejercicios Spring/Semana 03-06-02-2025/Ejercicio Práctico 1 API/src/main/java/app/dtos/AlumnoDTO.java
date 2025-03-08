package app.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoDTO {

    @JsonProperty("alumnoIdentificador")
    private Long id;

    @JsonProperty("alumnoNombre")
    private String nombre;

    @JsonProperty("alumnoApellido")
    private String apellido;

}
