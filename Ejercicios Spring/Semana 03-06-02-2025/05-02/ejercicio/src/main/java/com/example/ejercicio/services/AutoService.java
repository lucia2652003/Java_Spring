package com.example.ejercicio.services;

import com.example.ejercicio.dtos.AutoDTO;
import com.example.ejercicio.entities.Auto;
import com.example.ejercicio.repositories.IAutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutoService implements IAutoService{

    @Autowired
    IAutoRepository repository;

    @Override
    public List<AutoDTO> mostrarInfoAutos() {
        List<Auto> listado = repository.findAll();
        return listado.stream()
                      .map(this::conversorAutoToAutoDTO)
                      .toList();
    }

    @Override
    public AutoDTO crear(AutoDTO autoDTO) {
        Auto auto = this.conversorAutoDTOToAuto(autoDTO);
        repository.save(auto);
        return this.conversorAutoToAutoDTO(auto);
    }

    @Override
    public AutoDTO buscarAutoID(Long identificador) {
        Optional<Auto> existe = repository.findById(identificador);
        return existe.map(this::conversorAutoToAutoDTO)
                      .orElse(this.conversorAutoToAutoDTO(new Auto(null, null, null, null, null, null)));

    }

    @Override
    public List<AutoDTO> mostrarAutosOrdenPrecio() {
        return this.mostrarInfoAutos().stream()
                                      .sorted((autoDTO1, autoDTO2) -> autoDTO1.getPrecioAuto().compareTo(autoDTO2.getPrecioAuto()))
                                      .toList();
    }

    @Override
    public Auto conversorAutoDTOToAuto(AutoDTO autoDTO) {
        return new Auto(autoDTO.getIdentificador(), autoDTO.getMarcaAuto(), autoDTO.getModeloAuto(), autoDTO.getKmAuto(), autoDTO.getPuertasAuto(), autoDTO.getPrecioAuto());
    }

    @Override
    public AutoDTO conversorAutoToAutoDTO(Auto auto) {
        return new AutoDTO(auto.getId(), auto.getMarca(), auto.getModelo(), auto.getKm(), auto.getPuertas(), auto.getPrecio());
    }
}
