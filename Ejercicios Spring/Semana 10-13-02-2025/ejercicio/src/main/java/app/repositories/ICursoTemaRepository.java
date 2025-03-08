package app.repositories;

import app.entities.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Demostrar todos los temas con sus cursos correspondientes
@Repository
public interface ICursoTemaRepository extends JpaRepository<Tema, Long> {
}
