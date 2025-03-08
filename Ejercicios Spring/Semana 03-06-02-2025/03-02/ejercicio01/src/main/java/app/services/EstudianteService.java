package app.services;

import app.models.Estudiante;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//Contiene la lógica de negocio
@Service
public class EstudianteService implements IEstudianteService{

    private List<Estudiante> clase;

    public EstudianteService() {
        this.clase = new ArrayList<>();

        this.clase.add(new Estudiante(12815L, "Lucia", "Blanco", LocalDate.of(2013,5,26)));
        this.clase.add(new Estudiante(21418L, "Pablo", "Otero", LocalDate.of(2010,4,8)));
        this.clase.add(new Estudiante(31814L, "Paula", "Perez", LocalDate.of(2009,9,12)));
        this.clase.add(new Estudiante(47410L, "Noelia", "Campos", LocalDate.of(2012,12,12)));
        this.clase.add(new Estudiante(51722L, "Servando", "Ramos", LocalDate.of(2012,5,6)));
    }

    @Override
    public List<Estudiante> obtenerTodosEmp() {
        return this.clase;
    }

    @Override
    public Estudiante buscarEmpleado(Long numMatrcula) {
        return this.clase.stream()
                .filter(estudiante -> estudiante.getNum_matricula().equals(numMatrcula))
                .findFirst().orElse(null);
    }
}
