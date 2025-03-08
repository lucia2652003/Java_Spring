package com.example.app.servicies;

import com.example.app.dtos.TemaDTO;
import com.example.app.entities.Tema;

import java.util.List;

public interface ITemaService {

    //Mostrar todos los temas
    List<TemaDTO> mostrarTemas();

    //Crear tema
    TemaDTO crearTema(TemaDTO temaDTO);

    //Temas de un curso
    List<TemaDTO> mostrarTemasCurso(String nombreCurso);

    //Modificar tema
    TemaDTO actualizarTema(Long id, TemaDTO entidad);

    //Conversores
    TemaDTO conversorDTO(Tema tema);
    Tema conversorEntidad(TemaDTO temaDTO);


}
