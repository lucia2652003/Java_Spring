package com.hackaboss.app.repositories;

import com.hackaboss.app.entities.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemaRepositorioInterfaz extends JpaRepository<Tema, Long> {
}
