package com.app.servicies;

import com.app.dtos.PersonaDTO;
import com.app.entities.Persona;
import com.app.repositories.IPersonaRepository;
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

    //Inyectar el mock en el servicio
    @InjectMocks
    private PersonaService service;

    //Simulacion del mock de mi repositorio
    @Mock
    private IPersonaRepository repository;

    //Pruebas Unitarias
    @Test
    @DisplayName("Encuentra la lista de personas")
    void encontrarTodasLasPersonas(){
        //los datos de todas las personas
        List<Persona> personas = List.of(
                new Persona(1L, "Lucia", "Blanco", 21),
                new Persona(2L, "Pablo", "Otero", 32),
                new Persona(3L, "Perla", "Pomez", 23)
        );

        //Define el comportamiento del mock del repo
        when(repository.findAll()).thenReturn(personas);

        //Llamar al metodo del servicio que quiero testear
        List<PersonaDTO> personasDelServicio = service.buscarTodos();

        //Verificar los valores del los atributos del los objetos DTO
        assertThat(personasDelServicio.get(0).getIdentificador()).isEqualTo(1L);
        assertThat(personasDelServicio.get(0).getNombre()).isEqualTo("Lucia");
        assertThat(personasDelServicio.get(0).getApellido()).isEqualTo("Blanco");
        assertThat(personasDelServicio.get(0).getEdad()).isEqualTo(21);

        //Verificar el tamanho de la lista
        assertThat(personasDelServicio.size()).isEqualTo(3);

    }

    @Test
    @DisplayName("Buscar persona por ID existente")
    void buscarPorId(){
        Long idBuscado = 1L;

        //creo el objeto que quiero que devuelva en el repositorio
        Optional<Persona> persona = Optional.of(new Persona(idBuscado, "Lucia", "Blanco", 21));

        when(repository.findById(idBuscado)).thenReturn(persona);

        //Buscar persona por servicio
        PersonaDTO personaObtenida = service.buscarPersonaId(idBuscado);

        //Convertir a DTO
        PersonaDTO personaConvertida = service.conversorPersonaToDTO(persona.get());

        //Verificacion de objetos no es nulo
        assertThat(personaObtenida).isNotNull();    //OK
        assertThat(personaObtenida).isEqualTo(personaConvertida);

    }

    @Test
    @DisplayName("No encuentra una persona")
    void buscarPorIdNoExistente(){
        Long idBuscado = 55L;

        //creo el objeto que quiero que devuelva en el repositorio
        Persona personaEsperada = new Persona(null, null, null, null);

        when(repository.findById(idBuscado)).thenReturn(Optional.of(personaEsperada));

        //Buscar persona por servicio
        PersonaDTO personaObtenida = service.buscarPersonaId(idBuscado);

        //Convertir a DTO
        Persona personaConvertida = service.conversorDTOToPersona(personaObtenida);

        //Verificacion de objetos
        assertThat(personaEsperada).isEqualTo(personaConvertida);

    }
}
