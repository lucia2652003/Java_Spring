package com.hackaboss.app.services;

import com.hackaboss.app.dtos.CiudadanoDTO;
import com.hackaboss.app.dtos.TurnoDTO;
import com.hackaboss.app.entities.Ciudadano;
import com.hackaboss.app.entities.Turno;
import com.hackaboss.app.respositories.TurnoRepositorioInterfaz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class TurnoService implements TurnoServicioInterfaz{

    @Autowired
    TurnoRepositorioInterfaz repository;

    @Override
    public List<TurnoDTO> buscarTodos() {
        List<Turno> listado = repository.findAll();
        return listado.stream().map(this::convertirHaciaDTO).toList();
    }

    @Override
    public List<TurnoDTO> buscarTodos(LocalDateTime fecha) { //2025/02/02T14:20:20
        List<Turno> listado = repository.findAll();
        return listado.stream()
                .filter(turno -> turno.getFechaHoraTurno().isAfter(fecha))
                .map(this::convertirHaciaDTO).toList();
    }

    @Override
    public TurnoDTO buscarPorTurneroId(Long idCodigoTurno) {
        Optional<Turno> turnoEncontrado =  repository.findByCodigoTurno(idCodigoTurno);
        return turnoEncontrado.map(this::convertirHaciaDTO).orElse(new TurnoDTO());
    }

    @Override
    public TurnoDTO crear(TurnoDTO entidad) {
        Turno turnoRecuperado = this.convertirHaciaEntidad(entidad);
        Long formateadorFecha = this.convertirFechaEnCodigoLong(entidad.getFechaHoraTurno()); //2025020221315254
        turnoRecuperado.setCodigoTurno(formateadorFecha);
        Turno turnoGuardado =  repository.save(turnoRecuperado);
        return this.convertirHaciaDTO(turnoGuardado);

    }

    @Override
    public TurnoDTO actualizar(Long id, TurnoDTO entidad) {
        Optional<Turno> turnoEncontrado = repository.findById(id);
        if (turnoEncontrado.isPresent()) {
            Turno turno = turnoEncontrado.get();

            //actualizar datos
            turno.setEstadoTurno(entidad.getEstadoTurno());
            turno.setFechaHoraTurno(entidad.getFechaHoraTurno());

            //convertir fecha en Long
            Long formateadorFecha = this.convertirFechaEnCodigoLong(entidad.getFechaHoraTurno());
            turno.setCodigoTurno(formateadorFecha);

            //actualizar turno
            Turno turnoActualizado = repository.save(turno);

            //convertir a DTO
            return this.convertirHaciaDTO(turnoActualizado);
        }else{
            throw new RuntimeException("Turno no encontrado con el ID : " + id);

        }
    }

    @Override
    public List<TurnoDTO> eliminar(Long id) {
        try{
           repository.deleteById(id);
        }catch (Exception e){
            throw  new RuntimeException("Turno no eliminado");
        }

        return this.buscarTodos();
    }

    @Override
    public TurnoDTO convertirHaciaDTO(Turno turno) {
        CiudadanoDTO ciudadanoDTO = new CiudadanoDTO();

        if (turno.getCiudadano().getTurnos() == null) {
            ciudadanoDTO.setIdentificador(turno.getCiudadano().getIdCiudadano());
            return new TurnoDTO(turno.getId(), turno.getEstadoTurno(), turno.getFechaHoraTurno(), turno.getCodigoTurno(),ciudadanoDTO);
        }else {
            ciudadanoDTO = new CiudadanoDTO(turno.getCiudadano().getIdCiudadano(), turno.getCiudadano().getNombre(), turno.getCiudadano().getApellido(), turno.getCiudadano().getEmail(), null);
            return new TurnoDTO(turno.getId(), turno.getEstadoTurno(), turno.getFechaHoraTurno(), turno.getCodigoTurno(), ciudadanoDTO);
        }

    }

    @Override
    public Turno convertirHaciaEntidad(TurnoDTO turnoDTO) {
        Ciudadano ciudadano = new Ciudadano(turnoDTO.getIdCiudadano().getIdentificador(),null,null,null,null);
        return new Turno(turnoDTO.getIdentificador(), turnoDTO.getEstadoTurno(), turnoDTO.getFechaHoraTurno(), turnoDTO.getCodigoTurno(),ciudadano);
    }

    @Override
    public Long convertirFechaEnCodigoLong(LocalDateTime dateTime) {
        //formato de salida
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        // Formatear la fecha y hora como string
        String formatoDateTime = dateTime.format(formato); // -> "20250202162020 "

        return Long.parseLong(formatoDateTime); // ->   20250202162020
    }
}
