package com.hackaboss.carreraAutos.services;

import com.hackaboss.carreraAutos.models.Equipo;

import java.util.List;

public interface IEquipoService {

    List<Equipo> obtenerInfoEquipos();
    Equipo buscarEquipo(String nombre);
    List<Equipo> agregarEquipo(Equipo equipo);
}
