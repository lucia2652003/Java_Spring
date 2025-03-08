package com.example.app.servicies;

import com.example.app.dtos.CursoDTO;
import com.example.app.entities.Curso;

import java.util.List;

public interface ICursoService {

    //Mostrar cursos
    List<CursoDTO> mostrarCursoInfo();

    //Añadir curso
    CursoDTO anhadirCurso(CursoDTO cursoDTO);

    //Buscar cursos que contengan la palabra
    List<CursoDTO> mostrarCursoNombre(String palabra);

    //Actualizar curso
    CursoDTO modificarCurso(Long id, CursoDTO entidad);

    //Conversores
    CursoDTO conversorDTO(Curso curso);
    Curso conversorEntidad(CursoDTO cursoDTO);
}
