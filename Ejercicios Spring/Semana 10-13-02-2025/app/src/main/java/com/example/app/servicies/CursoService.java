package com.example.app.servicies;

import com.example.app.dtos.CursoDTO;
import com.example.app.entities.Curso;
import com.example.app.repositories.ICursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService implements ICursoService{

    @Autowired
    ICursoRepository repository;

    @Override
    public List<CursoDTO> mostrarCursoInfo() {
        List<Curso> todos = repository.findAll();
        return todos.stream()
                .map(this::conversorDTO)
                .toList();
    }

    @Override
    public CursoDTO anhadirCurso(CursoDTO cursoDTO) {
        Curso curso = this.conversorEntidad(cursoDTO);
        Curso anhadido = repository.save(curso);
        return this.conversorDTO(anhadido);
    }

    @Override
    public List<CursoDTO> mostrarCursoNombre(String palabra) {
        List<CursoDTO> todosCursos = this.mostrarCursoInfo();

        if(palabra.isEmpty()) return todosCursos;
        else{
            return  todosCursos.stream()
                    .filter(curso-> curso.getNombre().toLowerCase().contains(palabra.toLowerCase()))
                    .toList();
        }
    }

    @Override
    public CursoDTO modificarCurso(Long id, CursoDTO entidad) {
        Optional<Curso> existe = repository.findById(id);

        //Si lo encuentra actualiza los parametros y luego en la DB
        if(existe.isPresent()){
            Curso encontrado = existe.get();

            encontrado.setNombre(entidad.getNombre());
            encontrado.setTipo(entidad.getTipo());
            encontrado.setFecha_Fin(entidad.getFecha());

            Curso actualizado = repository.save(encontrado);

            return this.conversorDTO(actualizado);
        }
        else return this.conversorDTO(new Curso(null, null, null, null, null));

    }

    @Override
    public CursoDTO conversorDTO(Curso curso) {
        return new CursoDTO(curso.getId_curso(), curso.getNombre(), curso.getTipo(), curso.getFecha_Fin());
    }

    @Override
    public Curso conversorEntidad(CursoDTO cursoDTO) {
        return new Curso(cursoDTO.getId_curso(), cursoDTO.getNombre(), cursoDTO.getTipo(), cursoDTO.getFecha(), null);
    }
}
