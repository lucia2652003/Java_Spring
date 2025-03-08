package app.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class AlumnoService implements IAlumnoService{

    private List<String> alumnos;

    public AlumnoService() {
        this.alumnos = new ArrayList<>();
        this.alumnos.add("Carlos");
        this.alumnos.add("Ana");
        this.alumnos.add("Pedro");
        this.alumnos.add("Luis");
        this.alumnos.add("Maria");
        this.alumnos.add("Bianca");
        this.alumnos.add("Carolina");
        this.alumnos.add("Sonia");
        this.alumnos.add("Ona");
        this.alumnos.add("Aitana");
        this.alumnos.add("Lola");
    }

    @Override
    public List<String> mostrarAlumnos() {
        return this.alumnos.stream().sorted().toList();
    }

    @Override
    public List<String> mostrarAlumnosPOST(List<String> listado) {
        Collections.sort(listado);
        return listado;
    }

}
