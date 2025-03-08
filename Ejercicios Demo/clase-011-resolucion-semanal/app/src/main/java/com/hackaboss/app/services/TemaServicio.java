package com.hackaboss.app.services;

import com.hackaboss.app.dtos.CursoDTO;
import com.hackaboss.app.dtos.TemaDTO;
import com.hackaboss.app.entities.Curso;
import com.hackaboss.app.entities.Tema;
import com.hackaboss.app.repositories.TemaRepositorioInterfaz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemaServicio implements TemaServicioInterfaz{

    @Autowired
    TemaRepositorioInterfaz repository;


    @Override
    public List<TemaDTO> buscarTodos() {
        List<Tema> listado = repository.findAll();
        return listado.stream().map(this::convertirHaciaDTO).toList();
    }

    @Override
    public List<TemaDTO> buscarPorCurso(Long idCurso) {
        List<Tema> listado = repository.findAll();
        List<Tema> listadoFiltrado = listado.stream().filter(tema -> tema.getCurso().getIdCurso().equals(idCurso)).toList();
        return listadoFiltrado.stream().map(this::convertirHaciaDTO).toList();
    }

    @Override
    public TemaDTO crear(TemaDTO temaDTO) {
        Tema temaConvertido = this.convertirHaciaEntidad(temaDTO);
        Tema temaGuardado =  repository.save(temaConvertido);
        return this.convertirHaciaDTO(temaGuardado);
    }

    @Override
    public TemaDTO actualizar(Long id, TemaDTO temaDTO) {
        return null;
    }

    @Override
    public TemaDTO convertirHaciaDTO(Tema tema) {
        CursoDTO cursoDTO = new CursoDTO();

        //crear
        if (tema.getCurso().getTemas() == null) {
            cursoDTO = new CursoDTO(tema.getCurso().getIdCurso(), null,null,null,null);
            return new TemaDTO(tema.getIdTema(), tema.getNombre(), tema.getDescripcion(),cursoDTO, tema.getCurso().getIdCurso().toString());
        }else{
            //find
            cursoDTO = new CursoDTO(tema.getCurso().getIdCurso(), tema.getCurso().getNombre(),tema.getCurso().getTipoCurso(),tema.getCurso().getFechaFinalizacion(),null);
            return new TemaDTO(tema.getIdTema(), tema.getNombre(), tema.getDescripcion(),cursoDTO, tema.getCurso().getNombre());
        }


    }

    @Override
    public Tema convertirHaciaEntidad(TemaDTO temaDTO) {
        Curso curso = new Curso(temaDTO.getCurso().getIdentificador(),null,null,null,null);
        return new Tema(temaDTO.getIdentificador(), temaDTO.getNombre(), temaDTO.getDescripcion(), curso);
    }
}
