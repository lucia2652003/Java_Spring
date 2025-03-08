package com.hackaboss.app.services;

import com.hackaboss.app.dtos.PilotoDTO;
import com.hackaboss.app.entitites.Equipo;
import com.hackaboss.app.entitites.Piloto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PilotoService implements PilotoServiceInterfaz{

    private List<Piloto> pilotos;

    public PilotoService() {
        List<Equipo> equiposDelPilotoA =  List.of(new Equipo(1L, "Ferrari", "Italia"), new Equipo(2L, "Alpine", "USA"));
        List<Equipo> equiposDelPilotoB =  List.of(new Equipo(2L, "Alpine", "USA"), new Equipo(3L, "McLaren", "Alemania"));

        this.pilotos = new ArrayList<>();

        this.pilotos.add(new Piloto(1L, "Brian", "Gomez", 33, "venezuela", equiposDelPilotoA));
        this.pilotos.add(new Piloto(1L, "Borja", "Lopez", 53, "españa", equiposDelPilotoB));

    }

    @Override
    public List<PilotoDTO> buscarPilotos() {
        return this.pilotos.stream()
                .map(piloto -> new PilotoDTO( piloto.getNombre(), piloto.getApellido(), piloto.getEquipos())).toList();
    }

    @Override
    public List<PilotoDTO> buscarPilotosPorEquipo(String nombreEquipo) {
        //                                                  alpine
        List<Piloto> pelitosPorEquipo = this.pilotos.stream()
                .filter(piloto -> piloto.getEquipos().stream()
                        .anyMatch(equipo -> equipo.getNombre().equalsIgnoreCase(nombreEquipo))).toList();

        List<PilotoDTO> pelitosDTOPorEquipo = pelitosPorEquipo.stream()
                .map(piloto -> new PilotoDTO( piloto.getNombre(), piloto.getApellido(), piloto.getEquipos())).toList();

        return pelitosDTOPorEquipo;
    }
}
