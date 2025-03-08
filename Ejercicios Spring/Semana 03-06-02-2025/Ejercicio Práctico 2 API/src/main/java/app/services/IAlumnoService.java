package app.services;

import java.util.List;

public interface IAlumnoService {

    //declarar métodos sin implementar, públicos

    List<String> mostrarAlumnos();
    List<String> mostrarAlumnosPOST(List<String> listado);

}
