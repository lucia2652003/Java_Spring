package app.dtos;

import app.entities.Turno;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data @AllArgsConstructor @NoArgsConstructor
public class TurnoCiudadanoDTO {

    @JsonProperty("codigoTurno")
    private Long codigo;

    @JsonProperty("ciudadano")
    private String nombreCompleto; //turno.getCiudadano().getNombre() + turno.getCiudadano().getApellido()

    @JsonProperty("fechaTurno")
    private LocalDate fecha;

    @JsonProperty("estadoTurno")
    private Turno.TipoEstado estado;

    public enum TipoEstado{
        ESPERA,
        ATENDIDO
    }}
