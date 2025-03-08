package app.servicies;

import app.dtos.TurnoCiudadanoDTO;
import app.entities.Turno;

import java.time.LocalDate;
import java.util.List;

public interface ITurnoCiudadanoService {
    List<TurnoCiudadanoDTO> mostrarInfo();

    //Filtrar Turnos
    List<TurnoCiudadanoDTO> obtenerTurnosFiltro(LocalDate fecha, String estado);

    TurnoCiudadanoDTO conversorTurnoToTurnoCiudadanoDTO(Turno turno);
}
