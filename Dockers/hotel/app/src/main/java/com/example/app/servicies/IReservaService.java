package com.example.app.servicies;

import com.example.app.dtos.ReservaDTO;
import com.example.app.entities.Reserva;

import java.time.LocalDateTime;
import java.util.List;

public interface IReservaService {

    //Mostrar todas las reservas
    List<ReservaDTO> mostrarInfoReservas();

    //Crear reserva
    ReservaDTO crearReserva(ReservaDTO reservaDTO);

    //Buscar reserva por ID
    ReservaDTO buscarReserva(Long id);

    //Mostrar reservas desde fecha de inicio hasta de fin
    List<ReservaDTO> mostrarReservasFechas(LocalDateTime fechaInicio, LocalDateTime fechaFin);

    //Actualizar la reserva
    ReservaDTO modificarReserva(Long id, ReservaDTO reservaDTO);

    //Conversores
    ReservaDTO conversorDTO(Reserva reserva);
    Reserva conversorEntidad(ReservaDTO reservaDTO);
}
