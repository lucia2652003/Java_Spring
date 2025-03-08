package app.services;

import app.dtos.TemaDTO;
import app.entities.Tema;

import java.util.List;

public interface ITemaService {

    //Mostrar todos los temas
    List<TemaDTO> mostrarInfoTemas();

    //Crear tema
    TemaDTO ingresarTema(TemaDTO entidad);

    //Modificar tema
    TemaDTO actualizarTema(Long id, TemaDTO entidad);

    //Conversores
    TemaDTO conversorTemaToDTO(Tema tema);
    Tema conversorDTOToTema(TemaDTO temaDTO);
}
