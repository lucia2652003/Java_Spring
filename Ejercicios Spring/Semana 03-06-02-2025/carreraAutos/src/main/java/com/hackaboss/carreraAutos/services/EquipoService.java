package com.hackaboss.carreraAutos.services;

import com.hackaboss.carreraAutos.models.Equipo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EquipoService implements IEquipoService{

    private List<Equipo> competencia;

    public EquipoService() {
        this.competencia = new ArrayList<>();

        this.competencia.add(new Equipo(1L, "Ferrari", "España"));
        this.competencia.add(new Equipo(2L, "Toyota", "Francia"));
    }

    @Override
    public List<Equipo> obtenerInfoEquipos() {
        return this.competencia;
    }

    @Override
    public Equipo buscarEquipo(String nombre) {
        return this.competencia.stream()
                                .filter(equipo -> equipo.getNombreEquipo().equalsIgnoreCase(nombre))
                                .findFirst()
                                .orElse(null);
    }

    @Override
    public List<Equipo> agregarEquipo(Equipo equipo) {
        equipo.setIdEquipo(this.competencia.size()+1L);
        this.competencia.add(equipo);
        return this.competencia;
    }
}
