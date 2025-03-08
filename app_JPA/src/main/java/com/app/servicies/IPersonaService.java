package com.app.servicies;

import com.app.dtos.PersonaDTO;
import com.app.entities.Persona;

import java.util.List;

public interface IPersonaService {

    //Buscar todas las personas
    List<PersonaDTO> buscarTodos();

    //Buscar persona
    PersonaDTO buscarPersonaId(Long id);

    //Crear persona/recurso
    PersonaDTO crearPersona(PersonaDTO personaDTO);

    //Actualizar persona/recurso
    PersonaDTO actualizarPersona(Long id, PersonaDTO entidad);

    //Eliminar persona/recurso
    List<PersonaDTO> eliminarPersona(Long id);

    //Conversores
    PersonaDTO conversorPersonaToDTO(Persona persona);
    Persona conversorDTOToPersona(PersonaDTO persona);
}
