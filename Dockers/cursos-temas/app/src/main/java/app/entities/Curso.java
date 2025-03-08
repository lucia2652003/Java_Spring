package app.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoCurso tipo;
    public enum TipoCurso{
        BASICO,
        MEDIO,
        SUPERIOR
    }

    @Column(nullable = false)
    private LocalDate fechaFin;

    @OneToMany(mappedBy = "curso",
                 fetch = FetchType.LAZY,
                 orphanRemoval = true,
                 cascade = CascadeType.ALL)
    private Set<Tema> temas;

}
