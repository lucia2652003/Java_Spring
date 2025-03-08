package app.repositories;

import app.entities.Ciudadano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICiudadanoRepository extends JpaRepository<Ciudadano, Long> {
}
