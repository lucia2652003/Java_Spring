package app.services;

import app.dtos.CursoDTO;
import app.entities.Curso;

import java.util.List;

public interface ICursoService {

    //Mostrar Curso
    List<CursoDTO> mostrarInfo();

    //Añadir un curso
    CursoDTO crearCurso(CursoDTO cursoDTO);

    //Mostrar curso que contengan esa palabra
    List<CursoDTO> mostrarCursosNombre(String nombre);

    //Actualizar curso por id
    CursoDTO actualizarCurso(Long id, CursoDTO cursoDTO);

    //conversor
    CursoDTO conversorCursoToDTO(Curso curso);
    Curso conversorDTOToCurso(CursoDTO cursoDTO);
}
