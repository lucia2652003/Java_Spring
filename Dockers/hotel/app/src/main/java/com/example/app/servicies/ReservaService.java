package com.example.app.servicies;

import com.example.app.dtos.ClienteDTO;
import com.example.app.dtos.ReservaDTO;
import com.example.app.entities.Cliente;
import com.example.app.entities.Reserva;
import com.example.app.repository.IReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaService implements IReservaService{

    @Autowired
    IReservaRepository repository;

    @Override
    public List<ReservaDTO> mostrarInfoReservas() {
        List<Reserva> todos = repository.findAll();
        return todos.stream()
                .map(this::conversorDTO)
                .toList();
    }

    @Override
    public ReservaDTO crearReserva(ReservaDTO reservaDTO) {
        List<ReservaDTO> listado = this.mostrarInfoReservas();

        //Si existe una reserva que se encuentra desde tal fecha de inicio en un tiempo igual
        Optional<ReservaDTO> existe = listado.stream()
                .filter(reservaDTO1 -> reservaDTO1.getFechaIN().equals(reservaDTO.getFechaIN()))
                .findFirst();

        if(existe.isPresent()) return new ReservaDTO();
        else{
            Reserva nuevo = this.conversorEntidad(reservaDTO);
            Reserva creado = repository.save(nuevo);
            return this.conversorDTO(creado);
        }

    }

    @Override
    public ReservaDTO buscarReserva(Long id) {
        Optional<Reserva> existe = repository.findById(id);
        if(existe.isPresent()){
            Reserva encontrado = existe.get();
            return this.conversorDTO(encontrado);
        }
        else return new ReservaDTO();
    }

    @Override
    public List<ReservaDTO> mostrarReservasFechas(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        //Mostrar aquellos con la reserva que se encuentran desde fechas de inicio hasta fecha de fin, si están
        // vacíos los parámetros se muestra el listado al completo
        if(fechaFin.toString().isEmpty() || fechaInicio.toString().isEmpty()) return this.mostrarInfoReservas();
        return this.mostrarInfoReservas().stream()
                .filter(reserva -> reserva.getFechaIN().isAfter(fechaInicio) && reserva.getFechaFN().isBefore(fechaFin))
                .toList();
    }


    @Override
    public ReservaDTO modificarReserva(Long id, ReservaDTO reservaDTO) {

        Optional<Reserva> existe = repository.findById(id);

        if(existe.isPresent()){
            Reserva encontrado = existe.get();

            encontrado.setFecha_Inicio(reservaDTO.getFechaIN());
            encontrado.setFecha_Fin(reservaDTO.getFechaFN());
            encontrado.setNum_habitaciones(reservaDTO.getHab());
            encontrado.setCliente(new Cliente(reservaDTO.getCliente().getIdentificadorCliente(), null, null, null, null, null, null, null));

            Reserva actualizado = repository.save(encontrado);
            return this.conversorDTO(actualizado);
        }
        else return new ReservaDTO();

    }

    @Override
    public ReservaDTO conversorDTO(Reserva reserva) {
        ClienteDTO clienteDTO;

        if(reserva.getCliente().getReservas() == null){
            clienteDTO = new ClienteDTO(reserva.getCliente().getId_cliente(), null, null, null,null, null, null, null);

            return new ReservaDTO(reserva.getId_reserva(),
                    reserva.getFecha_Inicio(), reserva.getFecha_Fin(),
                    reserva.getNum_habitaciones(),
                    clienteDTO,
                    reserva.getCliente().getId_cliente().toString());
        }else{
            clienteDTO = new ClienteDTO(reserva.getCliente().getId_cliente(), reserva.getCliente().getNombre(), reserva.getCliente().getApellido(), reserva.getCliente().getDni(),reserva.getCliente().getNacion(),reserva.getCliente().getCorreo(),reserva.getCliente().getTelefonho(), null);

            return new ReservaDTO(reserva.getId_reserva(),
                    reserva.getFecha_Inicio(), reserva.getFecha_Fin(),
                    reserva.getNum_habitaciones(),
                    clienteDTO,
                    reserva.getCliente().getNombre() + " "+reserva.getCliente().getApellido());
        }
    }

    @Override
    public Reserva conversorEntidad(ReservaDTO reservaDTO) {
        Cliente existe = new Cliente(reservaDTO.getCliente().getIdentificadorCliente(), null, null, null, null, null, null, null);
        return new Reserva(reservaDTO.getIdentificadorReserva(), reservaDTO.getFechaIN(), reservaDTO.getFechaFN(), reservaDTO.getHab(), existe);
    }
}
