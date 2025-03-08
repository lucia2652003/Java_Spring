package com.hackaboss.app.services;

import com.hackaboss.app.dtos.TurnoDTO;
import com.hackaboss.app.entities.Turno;

import java.time.LocalDateTime;
import java.util.List;

public interface TurnoServicioInterfaz {

    List<TurnoDTO> buscarTodos();

    List<TurnoDTO> buscarTodos(LocalDateTime fecha);

    TurnoDTO buscarPorTurneroId(Long id);

    TurnoDTO crear(TurnoDTO entidad);

    TurnoDTO actualizar(Long id, TurnoDTO entidad);

    List<TurnoDTO> eliminar(Long id);

    //conversores
    TurnoDTO convertirHaciaDTO(Turno turno);

    Turno convertirHaciaEntidad (TurnoDTO turnoDTO);

    Long convertirFechaEnCodigoLong(LocalDateTime dateTime);
}
