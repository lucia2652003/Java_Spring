package app.servicies;

import app.dtos.TurnoDTO;
import app.entities.Ciudadano;
import app.entities.Turno;
import app.repositories.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService implements ITurnoService{

    @Autowired
    ITurnoRepository repository;

    @Override
    public List<TurnoDTO> mostrarTurnos() {
        List<Turno> listado = repository.findAll();
        return listado.stream()
                      .map(this::conversorTurnoToTurnoDTO)
                      .toList();
    }

    @Override
    public TurnoDTO crearTurno(TurnoDTO turnoDTO) {
        Turno turno = this.conversorTurnoDTOToTurno(turnoDTO);

        //Igual al número de Turno
        List<Turno> todosTurnos = this.mostrarTurnos().stream()
                                                      .map(this::conversorTurnoDTOToTurno)
                                                      .toList();

        Optional<Turno> existe = todosTurnos.stream()
                .filter(turno1 -> turno1.getNumTurno().equals(turno.getNumTurno()))
                .findFirst();

        if(existe.isEmpty()){
            repository.save(turno);
            return this.conversorTurnoToTurnoDTO(turno);
        }else {
            return new TurnoDTO(null, null, null, null, null, null);
        }
    }

    @Override
    public TurnoDTO buscarTurnoID(Long id) {
        Optional<Turno> existe = repository.findById(id);

        if(existe.isEmpty()) return new TurnoDTO(null, null, null, null, null, null);
        else return this.conversorTurnoToTurnoDTO(existe.get());
    }

    @Override
    public TurnoDTO actualizar(Long id, TurnoDTO entidad) {
        Optional<Turno> existe = repository.findById(id);

        if(existe.isEmpty()) return new TurnoDTO(null, null, null, null, null, null);
        else {
            Turno encontrado = existe.get();

            encontrado.setNumTurno(entidad.getCodiTurno());
            encontrado.setFecha(entidad.getFecha());
            encontrado.setDescripcion(entidad.getDescripcion());
            encontrado.setEstado(encontrado.getEstado());
            encontrado.setCiudadano(new Ciudadano(entidad.getIdentificadorCiudadano(), null,null, null));

            repository.save(encontrado);//Actualizarlo en DB

            return this.conversorTurnoToTurnoDTO(encontrado);
        }
    }

    @Override
    public List<TurnoDTO> eliminar(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("No se ha podido eliminar el Turno con el ID: "+id);
        }
        return mostrarTurnos();
    }


    @Override
    public TurnoDTO conversorTurnoToTurnoDTO(Turno turno) {
        return new TurnoDTO(turno.getId(),turno.getNumTurno(), turno.getFecha(), turno.getDescripcion(), turno.getEstado(), turno.getCiudadano().getId());
    }

    @Override
    public Turno conversorTurnoDTOToTurno(TurnoDTO turnoDTO) {
        return new Turno(turnoDTO.getIdentificador(),turnoDTO.getCodiTurno(), turnoDTO.getFecha(), turnoDTO.getDescripcion(), turnoDTO.getEstado(), new Ciudadano(turnoDTO.getIdentificadorCiudadano(), null,null, null));
    }
}
