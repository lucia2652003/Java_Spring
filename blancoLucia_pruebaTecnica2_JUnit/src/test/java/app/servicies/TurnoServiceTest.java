package app.servicies;

import app.dtos.TurnoDTO;
import app.entities.Ciudadano;
import app.entities.Turno;
import app.repositories.ITurnoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TurnoServiceTest {

    @InjectMocks
    TurnoService service;

    @Mock
    ITurnoRepository repository;

    @Test
    @DisplayName("Mostrar Turnos")
    void mostrarTurnos(){
        List<Turno> todosTurnos = List.of(
                new Turno(1L, 34L, LocalDate.of(2025, 5, 14),  "NUTRICIONISTA",Turno.TipoEstado.ESPERA, new Ciudadano(8L, "Lucia", "Blanco", null)),
                new Turno(2L, 69L, LocalDate.of(2025, 10, 3),  "DENTISTA",Turno.TipoEstado.ATENDIDO, new Ciudadano(6L, "Lola", "Ramos", null)));

        when(repository.findAll()).thenReturn(todosTurnos);

        List<TurnoDTO> turnos = service.mostrarTurnos();

        //Verificacion
        assertThat(turnos.get(0).getCodiTurno()).isEqualTo(34L);
        assertThat(turnos.get(0).getEstado()).isEqualTo(Turno.TipoEstado.ESPERA);
    }

    @Test
    @DisplayName("Buscar turno por ID existente")
    void buscarTurnoID(){
        Long idBuscar = 1L;

        Optional<Turno> turnoExistente = Optional.of(new Turno(1L, 23L, LocalDate.of(2025, 8, 12), "DENTISTA", Turno.TipoEstado.ATENDIDO, new Ciudadano(1L, "Lucia", "Blanco", null)));

        when(repository.findById(idBuscar)).thenReturn(turnoExistente);

        TurnoDTO turnoEncontrado = service.buscarTurnoID(idBuscar);

        TurnoDTO turnoConvertido = service.conversorTurnoToTurnoDTO(turnoExistente.get());

        //Verificacion
        assertThat(turnoEncontrado).isEqualTo(turnoConvertido);
    }
}
