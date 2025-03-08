package com.hackaboss.app.services;

import com.hackaboss.app.dtos.CursoDTO;
import com.hackaboss.app.entities.Curso;

import java.util.List;

public interface CursoServicioInterfaz {

    //firmas de los metodos que van en el servicio
    List<CursoDTO> buscarTodos();

    CursoDTO buscarPorCurso(Long idCurso);

    List<CursoDTO> buscarCursosPorNombre(String nombre);

    CursoDTO crear(CursoDTO curso);

    CursoDTO actualizar(Long id, CursoDTO curso);

    //conversores
    CursoDTO convertirHaciaDTO(Curso curso);

    Curso convertirHaciaEntidad(CursoDTO cursoDTO);

}
