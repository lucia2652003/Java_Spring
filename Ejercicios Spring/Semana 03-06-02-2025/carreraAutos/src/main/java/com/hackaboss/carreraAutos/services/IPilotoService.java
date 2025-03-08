package com.hackaboss.carreraAutos.services;

import com.hackaboss.carreraAutos.dtos.PilotoDTO;
import com.hackaboss.carreraAutos.models.Piloto;

import java.util.List;

public interface IPilotoService {

    List<Piloto> mostrarInfoPilotos();
    List<Piloto> agregarPiloto(Piloto piloto);
    List<PilotoDTO> mostrarPilotosEquipo(String nombre_equipo);
}
