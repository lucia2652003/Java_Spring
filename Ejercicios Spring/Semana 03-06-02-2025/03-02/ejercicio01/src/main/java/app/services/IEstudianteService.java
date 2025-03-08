package app.services;

import app.models.Estudiante;

import java.util.List;

public interface IEstudianteService {

    List<Estudiante> obtenerTodosEmp();
    Estudiante buscarEmpleado(Long numMatrcula);

}
