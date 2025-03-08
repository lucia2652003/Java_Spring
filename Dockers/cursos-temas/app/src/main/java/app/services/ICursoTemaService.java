package app.services;

import app.dtos.CursoTemaDTO;
import app.entities.Tema;

import java.util.List;

public interface ICursoTemaService {

    //Mostrar todos los temas por curso
    List<CursoTemaDTO> todosCursoTemas();

    //Mostrar temas por curso
    List<CursoTemaDTO> mostrarTemasCurso(String nombreCurso);

    //Conversor
    CursoTemaDTO conversorTemaToDTO(Tema tema);
}
