package app.dtos;

import app.entities.Turno;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TurnoDTO {

    private Long identificador;

    @JsonProperty("codigoTurno")
    private Long codiTurno;

    @JsonProperty("fechaTurno")
    private LocalDate fecha;

    @JsonProperty("nombreTurno")
    private String descripcion;

    @JsonProperty("estadoTurno")
    private Turno.TipoEstado estado;
    public enum TipoEstado{
        ESPERA,
        ATENDIDO
    }


    @JsonProperty("codiCiudadano")
    private Long identificadorCiudadano;
}
