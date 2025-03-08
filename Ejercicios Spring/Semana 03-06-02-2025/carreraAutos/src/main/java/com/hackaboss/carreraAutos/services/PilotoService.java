package com.hackaboss.carreraAutos.services;

import com.hackaboss.carreraAutos.dtos.PilotoDTO;
import com.hackaboss.carreraAutos.models.Equipo;
import com.hackaboss.carreraAutos.models.Piloto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PilotoService implements IPilotoService{

    private List<Piloto> competidores;

     //Opción posible
     @Autowired
     private IEquipoService iEquipoService;

    //private List<Equipo> competencia;

    public PilotoService() {
        this.competidores = new ArrayList<>();

        this.competidores.add(new Piloto(1L, "Lucia", "Blanco", 21, "España"));
        this.competidores.add(new Piloto(2L, "Pablo", "Otero", 28, "España"));
        this.competidores.add(new Piloto(3L, "Pablo", "Otero", 28, "Francia"));
        this.competidores.add(new Piloto(4L, "Emily", "Ramos", 31, "Francia"));
        this.competidores.add(new Piloto(5L, "Brian", "Cardo", 25, "Francia"));
    }

    @Override
    public List<Piloto> mostrarInfoPilotos() {
        return this.competidores;
    }

    @Override
    public List<Piloto> agregarPiloto(Piloto piloto) {
        piloto.setIdPiloto(this.competidores.size()+1L);//Actualizar el ID del piloto
        this.competidores.add(piloto);
        return this.competidores;
    }

    @Override
    public List<PilotoDTO> mostrarPilotosEquipo(String nombre_equipo) {

        List<PilotoDTO> listado = new ArrayList<>();

        //Buscar el equipo
        Equipo buscado = this.iEquipoService.obtenerInfoEquipos().stream()
                .filter(equipo -> equipo.getNombreEquipo().equalsIgnoreCase(nombre_equipo))
                .findFirst()
                .orElse(null);

        //Buscar los pilotos cuya nacionalidad es igual a la de pais
        List<Piloto> pilotosEquipo = this.competidores.stream()
                 .filter(piloto -> piloto.getNacionalidad().equalsIgnoreCase(buscado.getPais()))
                .toList();

        //Añadir al listado
        pilotosEquipo.forEach(piloto -> {
            listado.add(new PilotoDTO(piloto.getNombrePiloto() +" "+ piloto.getApellidoPiloto(), buscado.getNombreEquipo()));
        });

        return listado;
    }
}
