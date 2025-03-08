package app.servicies;

import app.dtos.CiudadanoDTO;
import app.entities.Ciudadano;
import app.repositories.ICiudadanoRepository;
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
public class CiudadanoServiceTest {

    //Inyección de mock servicio
    @InjectMocks
    private CiudadanoService service;

    //Simulacion del repositorio
    @Mock
    private ICiudadanoRepository repository;

    @Test
    @DisplayName("Listado de ciudadanos")
    void listadoCiudadanos(){

        List<Ciudadano> ciudadanos = List.of(
                new Ciudadano(1L, "Lucia", "Blanco", null),
                new Ciudadano(2L, "Lola", "Ramos", null));

        when(repository.findAll()).thenReturn(ciudadanos);

        //Servicio
        List<CiudadanoDTO> todosCiudaDTO = service.mostrarCiudadanos();

        //Verificaciones con assert
        assertThat(todosCiudaDTO.get(0).getIdentificador()).isEqualTo(1L);
        assertThat(todosCiudaDTO.get(0).getNombre()).isNotEqualTo("Paula");
        assertThat(todosCiudaDTO.get(0).getApellido()).isEqualTo("Blanco");

    }

    @Test
    @DisplayName("Mostrar ciudadano por ID existente")
    void buscarCiudadanoPorID(){
        Long idBuscar = 1L;

        Optional<Ciudadano> ciudadano = Optional.of(new Ciudadano(idBuscar, "Paula", "Ramos", null));

        when(repository.findById(idBuscar)).thenReturn(ciudadano);

        CiudadanoDTO personaObtenida = service.buscarCiudadano(idBuscar);

        CiudadanoDTO personaEncontrada = service.conversorCiudadanoToCiudadanoDTO(ciudadano.get());

        //Verificacion asserts
        assertThat(personaObtenida).isEqualTo(personaEncontrada);
    }

    @Test
    @DisplayName("Mostrar ciudadano no existe")
    void buscarNoCiudadanoPorID(){
        Long idBuscar = 88L;

        Ciudadano personaEncontrada = new Ciudadano(null, null, null, null);

        when(repository.findById(idBuscar)).thenReturn(Optional.of(personaEncontrada));

        //Encontrar persona desde el servicio
        CiudadanoDTO personaObtenida = service.buscarCiudadano(idBuscar);

        Ciudadano personaConvertida = service.conversorCiudadanoDTOToCiudadano(personaObtenida);

        //Verificacion asserts
        assertThat(personaEncontrada).isEqualTo(personaConvertida);
    }
}
