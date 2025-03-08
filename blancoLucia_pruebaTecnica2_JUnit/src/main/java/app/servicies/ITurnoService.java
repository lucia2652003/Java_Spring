package app.servicies;

import app.dtos.TurnoDTO;
import app.entities.Turno;

import java.util.List;
import java.util.Optional;

public interface ITurnoService {

    List<TurnoDTO> mostrarTurnos();
    TurnoDTO crearTurno(TurnoDTO turnoDTO);

    //Buscar turno
    TurnoDTO buscarTurnoID(Long id);

    //Actualizar
    TurnoDTO actualizar(Long id, TurnoDTO entidad);

    //Eliminar
    List<TurnoDTO> eliminar(Long id);


    //Conversores
    TurnoDTO conversorTurnoToTurnoDTO(Turno turno);
    Turno conversorTurnoDTOToTurno(TurnoDTO turnoDTO);
}
