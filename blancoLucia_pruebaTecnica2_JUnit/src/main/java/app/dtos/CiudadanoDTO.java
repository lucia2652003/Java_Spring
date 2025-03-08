package app.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class CiudadanoDTO {

    private Long identificador;

    @JsonProperty("primerNombre")
    private String nombre;

    @JsonProperty("primerApellido")
    private String apellido;
}
