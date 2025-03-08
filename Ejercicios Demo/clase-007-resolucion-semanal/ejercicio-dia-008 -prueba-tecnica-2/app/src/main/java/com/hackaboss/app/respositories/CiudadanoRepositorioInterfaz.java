package com.hackaboss.app.respositories;

import com.hackaboss.app.entities.Ciudadano;
import com.hackaboss.app.entities.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CiudadanoRepositorioInterfaz extends JpaRepository<Ciudadano, Long> {

    Optional<Ciudadano> findByEmail(String email);
}
