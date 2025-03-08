package com.hackaboss.app.repositories;

import com.hackaboss.app.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepositorioInterfaz extends JpaRepository<Curso, Long> {
}
