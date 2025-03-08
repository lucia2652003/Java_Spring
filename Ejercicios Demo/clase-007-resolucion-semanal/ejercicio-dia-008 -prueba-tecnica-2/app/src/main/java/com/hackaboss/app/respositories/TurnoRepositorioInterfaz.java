package com.hackaboss.app.respositories;

import com.hackaboss.app.entities.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TurnoRepositorioInterfaz extends JpaRepository<Turno, Long> {

    Optional<Turno> findByCodigoTurno(Long codigoTurno);
}
