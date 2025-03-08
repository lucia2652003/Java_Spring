package app.services;

import app.models.Alumno;

import java.util.List;

public interface AlumnoServiceInterfaz {

    //declarar metodos sin implementarlos, publicos

    List<Alumno> obtenerTodosLosAlumnos();

    void crearAlumno(Alumno alumno);
}
