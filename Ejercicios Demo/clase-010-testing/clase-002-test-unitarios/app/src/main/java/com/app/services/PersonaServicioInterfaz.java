package com.app.services;

import com.app.dtos.PersonaDTO;
import com.app.entities.Persona;

import java.util.List;

public interface PersonaServicioInterfaz {

    //busar todos
    List<PersonaDTO> buscarTodos();

    //buscar recurso por ID
    PersonaDTO buscarPorId(Long id);

    //Crear un recurso
    PersonaDTO crear(PersonaDTO personaDTO);

    //Actualizar un recurso
    PersonaDTO actualizar(Long id, PersonaDTO entidad);

    //eliminar un recurso
    List<PersonaDTO> eliminar(Long id);

    //conversores
    PersonaDTO convertirPersonaHaciaDTO(Persona persona);

    Persona convertirDTOHaciaPersona(PersonaDTO personaDTO);
}
