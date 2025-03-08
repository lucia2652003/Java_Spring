package app.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Ciudadano {
    //Atributos
    /*Clave Principal*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    //Un ciudadano tiene varios turnos
    /* Hacemos como una clave foránea
     *  fetch : para buscar todos los datos como un SELECT * FROM
     *  cascade: actualizar en forma cascada
     *  orphanRemol: eliminación por cascada
     * */
    @OneToMany(mappedBy = "ciudadano",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Turno> turnos;
}
