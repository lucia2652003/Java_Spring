package app.servicies;

import app.dtos.TurnoCiudadanoDTO;
import app.entities.Turno;
import app.repositories.ITurnoCiudadanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TurnoCiudadanoService implements ITurnoCiudadanoService{

    @Autowired
    ITurnoCiudadanoRepository repository;

    @Override
    public List<TurnoCiudadanoDTO> mostrarInfo() {
        List<Turno> todosTurnos = repository.findAll();
        return todosTurnos.stream().map(this::conversorTurnoToTurnoCiudadanoDTO).toList();
    }

    @Override
    public List<TurnoCiudadanoDTO> obtenerTurnosFiltro(LocalDate fecha, String estado) {
        List<TurnoCiudadanoDTO> todos = mostrarInfo();

        return  todos.stream()
                .filter(turno ->
                         fecha.isBefore(turno.getFecha())
                        && turno.getEstado().name().equalsIgnoreCase(estado))
                .toList();
    }

    @Override
    public TurnoCiudadanoDTO conversorTurnoToTurnoCiudadanoDTO(Turno turno) {
        return new TurnoCiudadanoDTO(turno.getNumTurno(), turno.getCiudadano().getNombre() +" "+turno.getCiudadano().getApellido(), turno.getFecha(), turno.getEstado());
    }
}
