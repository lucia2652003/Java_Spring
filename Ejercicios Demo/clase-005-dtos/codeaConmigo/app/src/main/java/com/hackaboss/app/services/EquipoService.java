package com.hackaboss.app.services;

import com.hackaboss.app.dtos.EquipoDTO;
import com.hackaboss.app.entitites.Equipo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EquipoService implements EquipoServiceInterfaz{

    private List<Equipo> equipos;

    public EquipoService() {
        this.equipos = new ArrayList<>();
        //valores por defecto
        this.equipos.add(new Equipo(1L, "Ferrari", "Italia"));
        this.equipos.add(new Equipo(2L, "Alpine", "USA"));
        this.equipos.add(new Equipo(3L, "McLaren", "Alemania"));
    }

    @Override
    public List<Equipo> buscarEquiposInscritos() {
        return this.equipos;
    }

    @Override
    public EquipoDTO buscarEquipoPorNombre(String nombre) {
        Equipo equipoEncontrado = equipos.stream().filter(equipo ->
                    equipo.getNombre().equalsIgnoreCase(nombre)).findFirst().orElse(null);

        if (equipoEncontrado == null) {
            return  new EquipoDTO(null, null);
        }else{
            return new EquipoDTO(equipoEncontrado.getNombre(), equipoEncontrado.getPais());
        }

    }
}
