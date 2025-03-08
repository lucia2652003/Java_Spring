package app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Calificacion {

    private Long id;
    private List<Double> notas;
    private Double promedio;
    private Estudiante estudiante;

}
