package app.services;

import app.dtos.CursoDTO;
import app.dtos.TemaDTO;
import app.entities.Curso;
import app.entities.Tema;
import app.repositories.ICursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CursoService implements ICursoService{

    @Autowired
    ICursoRepository repository;

    @Override
    public List<CursoDTO> mostrarInfo() {
        List<Curso> todosCurso = repository.findAll();
        return todosCurso.stream()
                         .map(this::conversorCursoToDTO)
                         .toList();
    }

    @Override
    public CursoDTO crearCurso(CursoDTO cursoDTO) {
        //Si no existe el curso con el nombre del Curso se inserta en DB, de lo contrario se devuelve un CursoDTO vacío
        List<CursoDTO> listado = this.mostrarInfo();

        Optional<CursoDTO> existe = listado.stream()
                                           .filter(curso -> curso.getNombre().equalsIgnoreCase(cursoDTO.getNombre()))
                                           .findFirst();

        if(existe.isEmpty()){
            Curso curso = this.conversorDTOToCurso(cursoDTO);
            Curso guardado = repository.save(curso);
            return this.conversorCursoToDTO(guardado);
        }
        else return this.conversorCursoToDTO(new Curso(null, null, null, null, null));

    }

    @Override
    public List<CursoDTO> mostrarCursosNombre(String nombre) {
        List<CursoDTO> todos = this.mostrarInfo();
        if(nombre.isEmpty()) return  todos;
        else return todos.stream()
                    .filter(curso -> curso.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                    .toList();
    }

    @Override
    public CursoDTO actualizarCurso(Long id, CursoDTO cursoDTO) {
        Optional<Curso> existe = repository.findById(id);

        if(existe.isPresent()){ //Existe ese curso se actualizan todos los datos Curso y se almacena en la DB
            Curso encontrado = existe.get();

            encontrado.setNombre(cursoDTO.getNombre());
            encontrado.setTipo(cursoDTO.getTipo());
            encontrado.setFechaFin(cursoDTO.getFecha());

            Curso modificado = repository.save(encontrado);
            //Se devuelve el objeto encontrado en DTO
            return this.conversorCursoToDTO(modificado);
        }
        else return this.conversorCursoToDTO(new Curso(null, null, null, null, null));
    }


    @Override
    public CursoDTO conversorCursoToDTO(Curso curso) {
        return new CursoDTO(curso.getId(), curso.getNombre(), curso.getTipo(),curso.getFechaFin());
    }

    @Override
    public Curso conversorDTOToCurso(CursoDTO cursoDTO) {
        return new Curso(cursoDTO.getIdentificadorCurso(), cursoDTO.getNombre(), cursoDTO.getTipo(), cursoDTO.getFecha(), null);
    }
}
