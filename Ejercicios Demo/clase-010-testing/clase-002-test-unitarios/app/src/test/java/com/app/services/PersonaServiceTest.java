package com.app.services;

import com.app.dtos.PersonaDTO;
import com.app.entities.Persona;
import com.app.repositories.PesonaRepositorioInterfaz;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonaServiceTest {

    //inyectar el mock en el servicio
    @InjectMocks
    private PersonaService service;

    //simulacion del mock de mi repositorio
    @Mock
    private PesonaRepositorioInterfaz repository;

    //Pruebas unitarias

    @Test
    @DisplayName("Encuentra la lista de personas")
    void encontrarTodasLasPersonas(){
        //los datos que quiero que devuelva el repositorio mockeado
        List<Persona> personas = List.of(
                new Persona(1L, "Brian", "Gomez", 21),
                new Persona(2L, "Jiss", "Sanchez", 22)
        );

        //define el comportamiento del mock del repo
        when(repository.findAll()).thenReturn(personas);

        //llamar al metodo del servicio que quiero testear
        List<PersonaDTO> personasDelServicio = service.buscarTodos();

        //verificar los valores de los atributos de los objetos DTO
        assertThat(personasDelServicio.get(0).getIdentificador()).isEqualTo(1L);
        assertThat(personasDelServicio.get(0).getNombre()).isEqualTo("Brian");
        assertThat(personasDelServicio.get(0).getApellido()).isEqualTo("Gomez");
        assertThat(personasDelServicio.get(0).getEdad()).isEqualTo(21);

        //verificar el tamalo de la lista
        assertThat(personasDelServicio.size()).isEqualTo(2);

    }

    @Test
    @DisplayName("Encuentra una persona por ID existente")
    void buscarPorId(){
        Long idBuscado = 1L;

        //creo el objeto que quiero que devuelva el repositorio mockeado
        Optional<Persona> persona = Optional.of(new Persona(idBuscado, "Brian", "Gomez", 21));

        when(repository.findById(idBuscado)).thenReturn(persona);

        PersonaDTO personaObtenida = service.buscarPorId(idBuscado);

        //convertir de entidad a DTO
        PersonaDTO personaConvertida = service.convertirPersonaHaciaDTO(persona.get());

        //asserts
        assertThat(personaObtenida).isNotNull();                        //OK
        assertThat(personaObtenida).isEqualTo(personaConvertida);       //OK

    }


    @Test
    @DisplayName("No encuentra una persona por ID")
    void buscarPorIdNoExistente(){
        Long idNoExistente = 55L;

        //El objeto que mockearemos al repo
        Persona personaEsperada = new Persona(null,null,null,null);

        when(repository.findById(idNoExistente)).thenReturn(Optional.of(personaEsperada));

        //ejecutar el metodo del service
        PersonaDTO personaObtenida = service.buscarPorId(idNoExistente);

        Persona personaConvertida =  service.convertirDTOHaciaPersona(personaObtenida);

        assertThat(personaEsperada).isEqualTo(personaConvertida);

    }
}
