package com.example.app.servicies;

import com.example.app.dtos.ReservaDTO;
import com.example.app.entities.Cliente;
import com.example.app.entities.Reserva;
import com.example.app.repository.IReservaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ReservaServiceTest {

    @InjectMocks
    private ReservaService servicio;

    @Mock
    private IReservaRepository repository;

    @Test
    @DisplayName("Mostrar todas las reservas")
    void listarReservas(){
        List<Reserva> reservas = List.of(
                new Reserva(1L, LocalDateTime.of(2025,5,14,8,14,12),
                        LocalDateTime.of(2025,5,25, 10,7,12), 8,
                        new Cliente(2L, "Pablo", "Otero","182213367L", "Roma", "pablo@gmaicl.com", 638027166, null))
                ,
                new Reserva(2L, LocalDateTime.of(2025,10,25,10,45,0),
                        LocalDateTime.of(2025,11,12, 9,36,25), 1,
                        new Cliente(1L, "Lucia", "Blanco","58000209M", "España", "lucblareg@gmail.com", 609568350, null))
                ,
                new Reserva(3L, LocalDateTime.of(2025,9,9,9,30,0),
                LocalDateTime.of(2025,9,12, 10,50,30), 2,
                new Cliente(1L, "Lucia", "Blanco","58000209M", "España", "lucblareg@gmail.com", 609568350, null))
        );

        //Llamar al repositorio
        when(repository.findAll()).thenReturn(reservas);

        //Aplicar al servicio
        List<ReservaDTO> reservasDTO = servicio.mostrarInfoReservas();

        //Verificaciones de los datos
        assertThat(reservasDTO.get(0).getIdentificadorReserva()).isEqualTo(1L);
        assertThat(reservasDTO.get(0).getFechaIN()).isEqualTo(LocalDateTime.of(2025,5,14,8,14,12));
        assertThat(reservasDTO.get(0).getFechaFN()).isEqualTo(LocalDateTime.of(2025,5,25, 10,7,12));
        assertThat(reservasDTO.get(0).getHab()).isEqualTo(8);
        assertThat(reservasDTO.get(0).getCliente().getIdentificadorCliente()).isEqualTo(2L);

    }


    @Test
    @DisplayName("Listar las reservas por fecha e inicio")
    void listarReservasFechas(){
        //Fechas de inicio y fin
        LocalDateTime inicio = LocalDateTime.now();
        LocalDateTime fin = LocalDateTime.of(2025, 11, 25, 15, 26, 47);

        List<Reserva> reservas = List.of(
                new Reserva(1L, LocalDateTime.of(2025,5,14,8,14,12),
                        LocalDateTime.of(2025,5,25, 10,7,12), 8,
                        new Cliente(2L, "Pablo", "Otero","182213367L", "Roma", "pablo@gmaicl.com", 638027166, null))
                ,
                new Reserva(2L, LocalDateTime.of(2025,10,25,10,45,0),
                        LocalDateTime.of(2025,11,12, 9,36,25), 1,
                        new Cliente(1L, "Lucia", "Blanco","58000209M", "España", "lucblareg@gmail.com", 609568350, null))
                ,
                new Reserva(3L, LocalDateTime.of(2025,9,9,9,30,0),
                        LocalDateTime.of(2025,9,12, 10,50,30), 2,
                        new Cliente(1L, "Lucia", "Blanco","58000209M", "España", "lucblareg@gmail.com", 609568350, null))
        );

        //Llamar al repositorio
        when(repository.findAll()).thenReturn(reservas);

        //Aplicar al servicio
        List<ReservaDTO> reservasDTO = servicio.mostrarReservasFechas(inicio, fin);

        //Verificacion si no esta vacía
        assertThat(reservasDTO).isNotNull();
    }

    @Test
    @DisplayName("Buscar reserva por un ID existente")
    void buscarReservaID(){
        Long idBuscar = 1L;

        Optional<Reserva> existe = Optional.of(new Reserva(idBuscar, LocalDateTime.of(2025,5,14,8,14,12),
                        LocalDateTime.of(2025,5,25, 10,7,12), 8,
                        new Cliente(2L, "Pablo", "Otero","182213367L", "Roma", "pablo@gmaicl.com", 638027166, null)));

        //Llamar al repositorio
        when(repository.findById(idBuscar)).thenReturn(existe);

        //Aplicar al servicio
        ReservaDTO reservaObtenida = servicio.buscarReserva(idBuscar);
        ReservaDTO reservaConvertida = servicio.conversorDTO(existe.get());

        //Verificacion
        assertThat(reservaObtenida).isEqualTo(reservaConvertida);
    }


}
