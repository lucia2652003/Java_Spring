package app.services;

import app.dtos.TemaDTO;
import app.entities.Curso;
import app.entities.Tema;
import app.repositories.ITemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TemaService implements ITemaService{

    @Autowired
    ITemaRepository repository;

    @Override
    public List<TemaDTO> mostrarInfoTemas() {
        List<Tema> todosTemas = repository.findAll();
        return todosTemas.stream()
                .map(this::conversorTemaToDTO)
                .toList();
    }

    @Override
    public TemaDTO ingresarTema(TemaDTO entidad) {
        Tema tema = this.conversorDTOToTema(entidad);
        repository.save(tema);
        return this.conversorTemaToDTO(tema);
    }

    @Override
    public TemaDTO actualizarTema(Long id, TemaDTO entidad) {
        Optional<Tema> existe = repository.findById(id);

        if(existe.isEmpty()) return this.conversorTemaToDTO(new Tema(null, null, null, null));
        else {
            Tema encontrado = existe.get();

            encontrado.setNombre(entidad.getNombre());
            encontrado.setDescripcion(entidad.getDescripcion());
            encontrado.setCurso(new Curso(entidad.getCurso_asociado(), null, null, null,null));

            repository.save(encontrado);//Actualizar en la DB
            return this.conversorTemaToDTO(encontrado);
        }
    }

    @Override
    public TemaDTO conversorTemaToDTO(Tema tema) {
        return new TemaDTO(tema.getId(), tema.getNombre(), tema.getDescripcion(), tema.getCurso().getId());
    }

    @Override
    public Tema conversorDTOToTema(TemaDTO temaDTO) {
        Curso existe = new Curso(temaDTO.getCurso_asociado(), null,null, null, null);
        return new Tema(temaDTO.getIdentifTema(), temaDTO.getNombre(), temaDTO.getDescripcion(), existe);
    }
}
