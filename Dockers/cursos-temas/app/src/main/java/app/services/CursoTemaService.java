package app.services;

import app.dtos.CursoTemaDTO;
import app.entities.Tema;
import app.repositories.ICursoTemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoTemaService implements ICursoTemaService{
    @Autowired
    ICursoTemaRepository repository;


    @Override
    public List<CursoTemaDTO> todosCursoTemas() {
        return repository.findAll().stream()
                .map(this::conversorTemaToDTO)
                .toList();
    }

    @Override
    public List<CursoTemaDTO> mostrarTemasCurso(String nombreCurso) {
        return this.todosCursoTemas().stream()
                .filter(cursoTemaDTO -> cursoTemaDTO.getCurso().equalsIgnoreCase(nombreCurso))
                .toList();
    }

    @Override
    public CursoTemaDTO conversorTemaToDTO(Tema tema) {
        return new CursoTemaDTO(tema.getId(), tema.getNombre(),tema.getDescripcion(), tema.getCurso().getNombre());
    }
}
