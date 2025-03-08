package com.hackaboss.app.services;


import com.hackaboss.app.dtos.TemaDTO;
import com.hackaboss.app.entities.Tema;

import java.util.List;

public interface TemaServicioInterfaz {

    List<TemaDTO> buscarTodos();

    List<TemaDTO> buscarPorCurso(Long idCurso);

    TemaDTO crear(TemaDTO temaDTO);

    TemaDTO actualizar(Long id, TemaDTO temaDTO);

    //conversores
    TemaDTO convertirHaciaDTO(Tema tema);

    Tema convertirHaciaEntidad(TemaDTO temaDTO);
}
