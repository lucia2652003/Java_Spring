package com.example.ejercicio.services;

import com.example.ejercicio.dtos.AutoDTO;
import com.example.ejercicio.entities.Auto;

import java.util.List;

public interface IAutoService {

    //Mostrar autos
    List<AutoDTO> mostrarInfoAutos();

    //Crear auto
    AutoDTO crear(AutoDTO autoDTO);

    //Buscar auto por ID
    AutoDTO buscarAutoID(Long identificador);

    //Ordenamiento por precio
    List<AutoDTO> mostrarAutosOrdenPrecio();

    //Conversores
    Auto conversorAutoDTOToAuto(AutoDTO autoDTO);
    AutoDTO conversorAutoToAutoDTO(Auto auto);
}
