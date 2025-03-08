package com.example.app.repository;

import com.example.app.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/* Podemos coger los datos de nuestra DB */
@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long> {
}
