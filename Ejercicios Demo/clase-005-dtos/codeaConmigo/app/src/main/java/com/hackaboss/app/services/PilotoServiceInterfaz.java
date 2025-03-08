package com.hackaboss.app.services;

import com.hackaboss.app.dtos.PilotoDTO;

import java.util.List;

public interface PilotoServiceInterfaz {

    List<PilotoDTO> buscarPilotos();

    List<PilotoDTO> buscarPilotosPorEquipo(String nombreEquipo);
}
