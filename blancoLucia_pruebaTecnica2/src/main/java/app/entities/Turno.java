package app.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long numTurno;

    @Column
    private LocalDate fecha;

    @Column(nullable = false)
    private String descripcion;

   /* /*Columna valor no es nulo y hay dos tipos de estados*/
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoEstado estado;

    public enum TipoEstado{
        ESPERA,
        ATENDIDO
    }

    /* Un turno está asociado a un solo empleado y especifica la columna clave foránea de la entidad Ciudadano, como en la DB*/
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ciudadano_id",nullable = false)
    private Ciudadano ciudadano;
}
