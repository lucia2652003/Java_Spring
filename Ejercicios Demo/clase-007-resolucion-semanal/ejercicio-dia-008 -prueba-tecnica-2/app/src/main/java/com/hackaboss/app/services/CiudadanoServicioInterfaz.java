package com.hackaboss.app.services;

import com.hackaboss.app.dtos.CiudadanoDTO;
import com.hackaboss.app.entities.Ciudadano;

import java.time.LocalDateTime;
import java.util.List;

public interface CiudadanoServicioInterfaz {

    List<CiudadanoDTO> buscarTodos();
    
    CiudadanoDTO buscarPorEmail(String email);

    CiudadanoDTO crear(CiudadanoDTO entidad);

    CiudadanoDTO actualizar(Long id, CiudadanoDTO entidad);

    List<CiudadanoDTO> eliminar(Long id);

    //conversores
    CiudadanoDTO convertirHaciaDTO(Ciudadano ciudadano);

    Ciudadano convertirHaciaEntidad (CiudadanoDTO ciudadanoDTO);

}
