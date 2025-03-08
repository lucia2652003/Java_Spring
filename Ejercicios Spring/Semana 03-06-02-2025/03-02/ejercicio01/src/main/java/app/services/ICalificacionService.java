package app.services;

import app.models.Calificacion;

import java.util.List;

public interface ICalificacionService {

    Calificacion buscarCalificacion(Long numMatricula);
    List<Calificacion> mostrarCalificacionOrdDesc();
}
