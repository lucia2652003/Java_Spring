package app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

//Nos permite ahorrar, ya que establece los constructores, Getters y Setters.
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estudiante {

    private Long num_matricula;
    private String nombre;
    private String apellido;
    private LocalDate fechaNac;

}
