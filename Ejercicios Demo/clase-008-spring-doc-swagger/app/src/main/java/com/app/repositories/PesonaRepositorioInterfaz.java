package com.app.repositories;

import com.app.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PesonaRepositorioInterfaz extends JpaRepository<Persona, Long> {
}
