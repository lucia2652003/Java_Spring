package com.example.app.servicies;

import com.example.app.dtos.CursoDTO;
import com.example.app.dtos.TemaDTO;
import com.example.app.entities.Curso;
import com.example.app.entities.Tema;
import com.example.app.repositories.ITemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TemaService implements ITemaService{

    @Autowired
    ITemaRepository repository;

    @Override
    public List<TemaDTO> mostrarTemas() {
        List<Tema> todosTemas = repository.findAll();
        return todosTemas.stream()
                .map(this::conversorDTO)
                .toList();
    }

    @Override
    public TemaDTO crearTema(TemaDTO temaDTO) {
        Tema nuevo = this.conversorEntidad(temaDTO);
        Tema creado = repository.save(nuevo);
        return this.conversorDTO(creado);
    }

    @Override
    public List<TemaDTO> mostrarTemasCurso(String nombreCurso) {
        if(nombreCurso.isEmpty()) return this.mostrarTemas();
        else return repository.findAll().stream()
                .filter(tema -> tema.getCurso().getNombre().equalsIgnoreCase(nombreCurso))
                .map(this::conversorDTO)
                .toList();
    }

    @Override
    public TemaDTO actualizarTema(Long id, TemaDTO entidad) {
        Optional<Tema> existe = repository.findById(id);

        if(existe.isPresent()){
            Tema encontrado = existe.get();

            encontrado.setNombre(entidad.getTitulo());
            encontrado.setDescripcion(entidad.getDescripcion());
            encontrado.setCurso(new Curso(entidad.getIdentificadorCurso(), null, null, null, null));

            Tema actualizado = repository.save(encontrado);

            return this.conversorDTO(actualizado);
        }
        else return this.conversorDTO(new Tema(null, null, null, null));

    }

    @Override
    public TemaDTO conversorDTO(Tema tema) {
       return new TemaDTO(tema.getId_tema(), tema.getNombre(), tema.getDescripcion(), tema.getCurso().getId_curso());
    }

    @Override
    public Tema conversorEntidad(TemaDTO temaDTO) {
        Curso existe =  new Curso(temaDTO.getIdentificadorCurso(), null, null, null, null);
        return new Tema(temaDTO.getIdentificadorTema(), temaDTO.getTitulo(), temaDTO.getDescripcion(), existe);
    }
}
