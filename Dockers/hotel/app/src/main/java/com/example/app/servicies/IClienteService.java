package com.example.app.servicies;

import com.example.app.dtos.ClienteDTO;
import com.example.app.entities.Cliente;

import java.util.List;

public interface IClienteService {
    //Listar todos los clientes
    List<ClienteDTO> mostrarClientes();

    //Crear cliente
    ClienteDTO agregarCliente(ClienteDTO clienteDTO);

    //Actualizar cliente
    ClienteDTO modificarCliente(Long id, ClienteDTO clienteDTO);

    //Buscar cliente po ID
    ClienteDTO buscarCliente(Long id);

    //Eliminar cliente
    List<ClienteDTO> eliminarCliente(Long id);

    //Conversores
    ClienteDTO conversorDTO(Cliente cliente);
    Cliente conversorEntidad(ClienteDTO clienteDTO);

}
