package app.repositories;

import app.entities.Ciudadano;
import app.entities.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurnoCiudadanoRepository extends JpaRepository<Turno, Long> {
}
