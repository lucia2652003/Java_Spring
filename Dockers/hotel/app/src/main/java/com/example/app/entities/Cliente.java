package com.example.app.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    private String dni;

    @Column(nullable = false)
    private String nacion;

    @Column(nullable = false)
    private String correo;

    @Column(nullable = false)
    private Integer telefonho;

    /*Un cliente puede hacer varias reservas en ese hotel*/
    @JsonManagedReference
    @OneToMany(mappedBy = "cliente",
               fetch = FetchType.EAGER,
               cascade = CascadeType.ALL,
               orphanRemoval = true)
    private List<Reserva> reservas;
}
