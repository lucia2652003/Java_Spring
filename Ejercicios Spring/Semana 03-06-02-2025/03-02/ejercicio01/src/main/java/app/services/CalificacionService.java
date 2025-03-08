package app.services;

import app.models.Calificacion;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class CalificacionService implements ICalificacionService{

    private List<Calificacion> evaluacion;

    public CalificacionService() {
        this.evaluacion = new ArrayList<>();

        EstudianteService estudianteService = new EstudianteService();

        this.evaluacion.add(new Calificacion(1L, List.of(8.05 , 10.00, 9.02), calcularPromedio(List.of(8.05 , 10.00, 9.02)),estudianteService.buscarEmpleado(12815L)));
        this.evaluacion.add(new Calificacion(2L, List.of(5.15 , 4.04, 7.50), calcularPromedio(List.of(5.15 , 4.04, 7.50)),estudianteService.buscarEmpleado(21418L)));
        this.evaluacion.add(new Calificacion(3L, List.of(9.36, 7.20, 8.36), calcularPromedio(List.of(9.36, 7.20, 8.36)),estudianteService.buscarEmpleado(31814L)));
        this.evaluacion.add(new Calificacion(4L, List.of(3.02 , 1.20, 5.75), calcularPromedio(List.of(3.02 , 1.20, 5.75)),estudianteService.buscarEmpleado(47410L)));
        this.evaluacion.add(new Calificacion(5L, List.of(8.05 , 6.45, 9.02), calcularPromedio(List.of(8.05 , 10.00, 9.02)),estudianteService.buscarEmpleado(51722L)));

    }

    public Double calcularPromedio(List<Double> examenes) {
        return examenes.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
    }

    @Override
    public Calificacion buscarCalificacion(Long numMatricula) {
        return this.evaluacion.stream()
                .filter(calificacion -> calificacion.getEstudiante().getNum_matricula().equals(numMatricula))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Calificacion> mostrarCalificacionOrdDesc() {
        return this.evaluacion.stream()
                .map(c->
                        new Calificacion(c.getId(),
                                c.getNotas().stream()
                                        .sorted(Comparator.reverseOrder())
                                        .toList(),
                                c.getPromedio(),
                                c.getEstudiante()))
                .toList();
    }
}
