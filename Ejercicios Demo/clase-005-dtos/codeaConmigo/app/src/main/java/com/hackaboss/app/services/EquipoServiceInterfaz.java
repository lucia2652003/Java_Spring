package com.hackaboss.app.services;

import com.hackaboss.app.dtos.EquipoDTO;
import com.hackaboss.app.entitites.Equipo;

import java.util.List;

public interface EquipoServiceInterfaz {

    List<Equipo> buscarEquiposInscritos();

    EquipoDTO buscarEquipoPorNombre(String nombre);
}
