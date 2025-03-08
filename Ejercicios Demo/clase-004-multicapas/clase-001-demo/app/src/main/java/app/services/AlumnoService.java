package app.services;

import app.models.Alumno;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlumnoService implements AlumnoServiceInterfaz{

    private List<Alumno> alumnos;

    public AlumnoService() {
        this.alumnos = new ArrayList<>();
        this.alumnos.add(new Alumno(1L, "Brian", "Gomez"));
        this.alumnos.add(new Alumno(2L, "Carlos", "Andrade"));
        this.alumnos.add(new Alumno(3L, "Borja", "Lopez"));
    }

    @Override
    public List<Alumno> obtenerTodosLosAlumnos() {
        return this.alumnos;
    }

    @Override
    public void crearAlumno(Alumno alumno) {
        alumno.setId(this.alumnos.size() + 1L);
        this.alumnos.add(alumno);
    }
}
