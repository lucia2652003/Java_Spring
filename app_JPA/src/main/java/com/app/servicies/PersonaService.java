package com.app.servicies;

import com.app.dtos.PersonaDTO;
import com.app.entities.Persona;
import com.app.repositories.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService implements IPersonaService{

    @Autowired
    IPersonaRepository repository;

    @Override
    public List<PersonaDTO> buscarTodos() {
        List<Persona> personas = repository.findAll(); //Devuelve listado de personas pero List<Persona>

        return personas.stream()
                       .map(this::conversorPersonaToDTO)
                       .toList();
    }

    @Override
    public PersonaDTO buscarPersonaId(Long id) {
        Optional<Persona> persona = repository.findById(id);

        return persona.map(this::conversorPersonaToDTO)
                      .orElse(new PersonaDTO(null, null, null, null));
    }

    @Override
    public PersonaDTO crearPersona(PersonaDTO personaDTO) {
        Persona persona = this.conversorDTOToPersona(personaDTO);

        Persona personaGuardada = repository.save(persona);//Almacena en la DB

        return this.conversorPersonaToDTO(personaGuardada);
    }

    @Override
    public PersonaDTO actualizarPersona(Long id, PersonaDTO entidad) {
        Optional<Persona> persona = repository.findById(id);
        if(persona.isPresent()){

            //Actualizar cada atributo de la persona encontrada
            Persona existida = persona.get();
            existida.setNombre(entidad.getNombre());
            existida.setApellido(entidad.getApellido());
            existida.setEdad(entidad.getEdad());

            //Actualizar en la DB
            Persona actualizado = repository.save(existida);
            return this.conversorPersonaToDTO(actualizado);
        }
        else throw new RuntimeException("Persona no encontrada con el id: "+id);
    }

    @Override
    public List<PersonaDTO> eliminarPersona(Long id) {
        try {
            repository.deleteById(id); //Eliminar la persona de DB
        } catch (RuntimeException e) {
            throw new RuntimeException("Persona con el ID: "+id+" no sea eliminado");
        }
        return this.buscarTodos();
    }


    //Conversores
    @Override
    public PersonaDTO conversorPersonaToDTO(Persona persona) {
        return new PersonaDTO(persona.getId(), persona.getNombre(), persona.getApellido(), persona.getEdad());
    }

    @Override
    public Persona conversorDTOToPersona(PersonaDTO persona) {
        return new Persona(persona.getIdentificador(), persona.getNombre(), persona.getApellido(), persona.getEdad());
    }
}
