package com.example.app.servicies;

import com.example.app.dtos.ClienteDTO;
import com.example.app.dtos.ReservaDTO;
import com.example.app.entities.Cliente;
import com.example.app.entities.Reserva;
import com.example.app.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    IClienteRepository repository;

    @Override
    public List<ClienteDTO> mostrarClientes() {
        List<Cliente> todosCiudadanos = repository.findAll();
        return todosCiudadanos.stream()
                .map(this::conversorDTO)
                .toList();
    }

    @Override
    public ClienteDTO agregarCliente(ClienteDTO clienteDTO) {
        Cliente nuevo = this.conversorEntidad(clienteDTO);

        //Si hay un cliente con el mismo DNI no se inserte en la DB Y devuelve un vacío
        Optional<Cliente> existe = repository.findAll().stream()
                .filter(cliente->cliente.getDni().equalsIgnoreCase(nuevo.getDni()))
                .findFirst();

        if(existe.isPresent()) return new ClienteDTO();
        else {
            Cliente ingresado = repository.save(nuevo);
            return this.conversorDTO(ingresado);
        }
    }

    @Override
    public ClienteDTO modificarCliente(Long id, ClienteDTO clienteDTO) {
        Optional<Cliente> existe = repository.findById(id);

        //Si existe el cliente se actualiza todos los datos
        if(existe.isPresent()){
            Cliente encontrado = existe.get();

            encontrado.setNombre(clienteDTO.getNombre());
            encontrado.setApellido(clienteDTO.getApellido());
            encontrado.setDni(clienteDTO.getDni());
            encontrado.setNacion(clienteDTO.getNacion());
            encontrado.setCorreo(clienteDTO.getCorreo());
            encontrado.setTelefonho(clienteDTO.getMobil());

            Cliente modificado = repository.save(encontrado);

            return this.conversorDTO(modificado);
        } else return new ClienteDTO();
    }

    @Override
    public ClienteDTO buscarCliente(Long id) {
        Optional<Cliente> existe = repository.findById(id);

        if(existe.isPresent()){
            Cliente encontrado = existe.get();
            return  this.conversorDTO(encontrado);
        }else return new ClienteDTO();
    }

    @Override
    public List<ClienteDTO> eliminarCliente(Long id) {
        try {
            repository.deleteById(id);
            return this.mostrarClientes();
        } catch (Exception e) {
            throw new RuntimeException("No existe el cliente con ese ID "+id);
        }
    }

    @Override
    public ClienteDTO conversorDTO(Cliente cliente) {

        //Si el cliente no tienes unas reservas se muestra un cliente sin las reservas
        if(cliente.getReservas() == null){
            return new ClienteDTO(cliente.getId_cliente(), cliente.getNombre(), cliente.getApellido(), cliente.getDni(), cliente.getNacion(), cliente.getCorreo(), cliente.getTelefonho(), new ArrayList<>());
        }else {
            List<ReservaDTO> todasReservas = cliente.getReservas().stream()
                    .map(reserva -> new ReservaDTO(reserva.getId_reserva(), reserva.getFecha_Inicio(), reserva.getFecha_Fin(), reserva.getNum_habitaciones(),
                            null,
                            reserva.getCliente().getNombre()+" "+reserva.getCliente().getApellido())).toList();

            return new ClienteDTO(cliente.getId_cliente(), cliente.getNombre(), cliente.getApellido(), cliente.getDni(), cliente.getNacion(), cliente.getCorreo(), cliente.getTelefonho(), todasReservas);
        }

    }

    @Override
    public Cliente conversorEntidad(ClienteDTO clienteDTO) {
        return new Cliente(clienteDTO.getIdentificadorCliente(), clienteDTO.getNombre(), clienteDTO.getApellido(), clienteDTO.getDni(), clienteDTO.getNacion(), clienteDTO.getCorreo(), clienteDTO.getMobil(), null);
    }
}
