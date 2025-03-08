package app.services;

import app.models.Alumno;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlumnoService implements IAlumnoService{

    private List<Alumno> alumnos;

    public AlumnoService() {
        this.alumnos = new ArrayList<>();
        this.alumnos.add(new Alumno(1L, "Lucia", "Blanco"));
        this.alumnos.add(new Alumno(2L, "Maria", "Campos"));
        this.alumnos.add(new Alumno(3L, "Luis", "Perez"));
    }

    @Override
    public List<Alumno> mostrarAlumnos() {
        return this.alumnos;
    }

    @Override
    public void crearAlumnos(Alumno alumno) {
        alumno.setId(this.alumnos.size()+1L);//Actualizar el ID

        this.alumnos.add(alumno);//Añadirlo al listado
    }
}
