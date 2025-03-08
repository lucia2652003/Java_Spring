package com.hackaboss.prueba_dtos.service;

import com.hackaboss.prueba_dtos.dtos.PropiedadInquilinoDTO;
import com.hackaboss.prueba_dtos.models.Inquilino;
import com.hackaboss.prueba_dtos.models.Propiedad;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropiedadService implements IPropiedadService{

    private Propiedad propiedad;
    private Inquilino inquilino;

    public PropiedadService() {
        this.propiedad = new Propiedad(2545L, "Casa", "madrid 55", 28.0, 1000.0);
        this.inquilino = new Inquilino(15L, "58000209M", "Lucia", "Blanco", "Programadora");
    }

    @Override
    public PropiedadInquilinoDTO buscarInfoInquilino() {

        PropiedadInquilinoDTO propiedadInquilinoDTO = new PropiedadInquilinoDTO();

        propiedadInquilinoDTO.setTipoPropiedad(this.propiedad.getTipoPropiedad());
        propiedadInquilinoDTO.setDireccion(this.propiedad.getDireccion());
        propiedadInquilinoDTO.setValorAlquiler(this.propiedad.getValorAlquiler());
        propiedadInquilinoDTO.setNombreInquilino(this.inquilino.getNombre());
        propiedadInquilinoDTO.setApellidoInquilino(this.inquilino.getApellido());

        return propiedadInquilinoDTO;
    }
}
