package com.app.services;

import com.app.dtos.PersonaDTO;
import com.app.entities.Persona;
import com.app.repositories.PesonaRepositorioInterfaz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService implements PersonaServicioInterfaz{

    @Autowired
    PesonaRepositorioInterfaz repository;

    @Override
    public List<PersonaDTO> buscarTodos() {
        List<Persona> personas = repository.findAll();
        return personas.stream().map(this::convertirPersonaHaciaDTO).toList();
    }

    @Override
    public PersonaDTO buscarPorId(Long id) {
        Optional<Persona> persona = repository.findById(id);
        return persona.map(this::convertirPersonaHaciaDTO)
                .orElse(new PersonaDTO(null, null, null, null));
    }

    @Override
    public PersonaDTO crear(PersonaDTO personaDTO) {
        Persona personaRecuperada = this.convertirDTOHaciaPersona(personaDTO);
        Persona personaGuardada = repository.save(personaRecuperada);
        return this.convertirPersonaHaciaDTO(personaGuardada);
    }

    @Override
    public PersonaDTO actualizar(Long id, PersonaDTO entidad) {
        // verificar si la persona existe
        Optional<Persona> personaOptional = repository.findById(id);
        if (personaOptional.isPresent()) {
            //obtener la persona si esta presente
            Persona persona = personaOptional.get();

            //Actualizar cada atributo
            persona.setNombre(entidad.getNombre());
            persona.setApellido(entidad.getApellido());
            persona.setEdad(entidad.getEdad());

            //guardar en la DB
            Persona personaActualizada  = repository.save(persona);
            return this.convertirPersonaHaciaDTO(personaActualizada);
        }else{
            throw new RuntimeException("Persona no encontrada con el id: " + id);
        }

    }

    @Override
    public List<PersonaDTO> eliminar(Long id) {
        try{
            repository.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException("Persona con el ID: " + id + " no eliminada");
        }
        return this.buscarTodos();
    }


    //todo: conversores
    @Override
    public PersonaDTO convertirPersonaHaciaDTO(Persona persona) {
        return new PersonaDTO(persona.getId(), persona.getNombre(), persona.getApellido(), persona.getEdad());
    }

    @Override
    public Persona convertirDTOHaciaPersona(PersonaDTO personaDTO) {
        return new Persona(personaDTO.getIdentificador(), personaDTO.getNombre(), personaDTO.getApellido(), personaDTO.getEdad());
    }
}
