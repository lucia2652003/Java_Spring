package com.hackaboss.app.services;

import com.hackaboss.app.dtos.CiudadanoDTO;
import com.hackaboss.app.dtos.TurnoDTO;
import com.hackaboss.app.entities.Ciudadano;
import com.hackaboss.app.entities.Turno;
import com.hackaboss.app.respositories.CiudadanoRepositorioInterfaz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CiudadanoService implements CiudadanoServicioInterfaz{

    @Autowired
    CiudadanoRepositorioInterfaz repository;
    
    @Override
    public List<CiudadanoDTO> buscarTodos() {
        List<Ciudadano> listado = repository.findAll();
        return listado.stream().map(this::convertirHaciaDTO).toList();
    }

    @Override
    public CiudadanoDTO buscarPorEmail(String email) {
        Optional<Ciudadano> ciudadanoEncontrado =  repository.findByEmail(email);
        return ciudadanoEncontrado.map(this::convertirHaciaDTO).orElse(new CiudadanoDTO());
    }

    @Override
    public CiudadanoDTO crear(CiudadanoDTO entidad) {
        Ciudadano ciudadanoConvertido = this.convertirHaciaEntidad(entidad);
        Ciudadano ciudadanoGuardado =  repository.save(ciudadanoConvertido);
        return this.convertirHaciaDTO(ciudadanoGuardado);
    }

    @Override
    public CiudadanoDTO actualizar(Long id, CiudadanoDTO entidad) {
        Optional<Ciudadano> ciudadanoEncontrado = repository.findById(id);
        if (ciudadanoEncontrado.isPresent()) {
            Ciudadano ciudadano = ciudadanoEncontrado.get();

            //actualizar datos
            ciudadano.setNombre(entidad.getNombre());
            ciudadano.setApellido(entidad.getApellido());
            ciudadano.setEmail(entidad.getEmail());


            //actualizar ciudadano
            Ciudadano ciudadanoActualizado = repository.save(ciudadano);

            //convertir a DTO
            return this.convertirHaciaDTO(ciudadanoActualizado);
        }else{
            throw new RuntimeException("Ciudadano no encontrado con el ID : " + id);

        }
    }

    @Override
    public List<CiudadanoDTO> eliminar(Long id) {
        try{
            repository.deleteById(id);
        }catch (Exception e){
            throw  new RuntimeException("Turno no eliminado");
        }

        return this.buscarTodos();
    }

    @Override
    public CiudadanoDTO convertirHaciaDTO(Ciudadano ciudadano) {
        TurnoDTO turnoDTO = new TurnoDTO();

        if (ciudadano.getTurnos() == null) {
            turnoDTO = null;
            return null;
        }else{
            List<TurnoDTO> susTurnosDTO = ciudadano.getTurnos().stream().map(turno -> new TurnoDTO(turno.getId(), turno.getEstadoTurno(), turno.getFechaHoraTurno(), turno.getCodigoTurno(), null)).toList();
            return new CiudadanoDTO(ciudadano.getIdCiudadano(), ciudadano.getNombre(), ciudadano.getApellido(), ciudadano.getEmail(), susTurnosDTO);
        }


    }

    @Override
    public Ciudadano convertirHaciaEntidad(CiudadanoDTO ciudadanoDTO) {
        List<Turno> susTurnos = ciudadanoDTO.getTurnos().stream().map(turnoDTO -> new Turno(turnoDTO.getIdentificador(), turnoDTO.getEstadoTurno(), turnoDTO.getFechaHoraTurno(), turnoDTO.getCodigoTurno(), this.convertirHaciaEntidad(turnoDTO.getIdCiudadano()))).toList();
        return new Ciudadano(ciudadanoDTO.getIdentificador(), ciudadanoDTO.getNombre(), ciudadanoDTO.getApellido(), ciudadanoDTO.getEmail(), susTurnos);
    }
}
