package app.services;

import app.models.Alumno;

import java.util.List;

public interface IAlumnoService {

    //declarar métodos sin implementar, públicos

    List<Alumno> mostrarAlumnos();
    void crearAlumnos(Alumno alumno);
}
