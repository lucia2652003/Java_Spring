package com.example.app.servicies;

import com.example.app.dtos.ClienteDTO;
import com.example.app.entities.Cliente;
import com.example.app.repository.IClienteRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    //Inyeccion de los mocks servicio
    @InjectMocks
    private ClienteService servicio;

    //Simulacion de mock servicio
    @Mock
    private IClienteRepository repository;

    @Test
    @DisplayName("Listar todos los clientes")
    void listarClientes(){
        List<Cliente> listado = List.of(
                new Cliente(1L, "Lucia", "Blanco","58000209M", "España", "lucblareg@gmail.com", 609568350, new ArrayList<>()),
                new Cliente(2L, "Pablo", "Otero","182213367L", "Roma", "pablo@gmaicl.com", 638027166, new ArrayList<>()),
                new Cliente(3L, "Luis", "Ramos","925152251O", "Francia", "luis@gmaicl.com", 609568350, new ArrayList<>())
        );

        //Repositorio
        when(repository.findAll()).thenReturn(listado);

        //Llamar al servicio
        List<ClienteDTO> listadoCLS = servicio.mostrarClientes();

        //Verificacion
        assertThat(listadoCLS.get(0).getIdentificadorCliente()).isEqualTo(1L);
        assertThat(listadoCLS.get(0).getNombre()).isEqualTo("Lucia");
        assertThat(listadoCLS.get(0).getApellido()).isEqualTo("Blanco");
        assertThat(listadoCLS.get(0).getDni()).isEqualTo("58000209M");
        assertThat(listadoCLS.get(0).getNacion()).isEqualTo("España");
        assertThat(listadoCLS.get(0).getCorreo()).isEqualTo("lucblareg@gmail.com");
        assertThat(listadoCLS.get(0).getMobil()).isEqualTo(609568350);

    }

    @Test
    @DisplayName("Buscar clientes por id existente")
    void buscarClienteIDExistente(){
        Long idBuscar = 1L;

        Optional<Cliente> cliente = Optional.of(new Cliente(idBuscar, "Lucia", "Blanco", "58000209M", "España", "lucblareg@gmail.com", 609568350, new ArrayList<>()));

        when(repository.findById(idBuscar)).thenReturn(cliente);

        //Servicio
        ClienteDTO clienteObtenido = servicio.buscarCliente(idBuscar);
        ClienteDTO clienteEncontrada = servicio.conversorDTO(cliente.get());

        //Verificacion
        assertThat(clienteEncontrada).isNotNull();
        assertThat(clienteObtenido).isEqualTo(clienteEncontrada);
    }


}
