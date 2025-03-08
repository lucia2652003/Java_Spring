package com.hackaboss.app.services;

import com.hackaboss.app.dtos.PropiedadInquilinoDTO;
import com.hackaboss.app.models.Inquilino;
import com.hackaboss.app.models.Propiedad;
import org.springframework.stereotype.Service;

@Service
public class PropiedadService implements PropiedadServiceInterfaz{

    private Propiedad propiedad;
    private Inquilino inquilino;

    public PropiedadService() {
        this.propiedad = new Propiedad(2545L, "Casa", "madrid 555", 90.0, 1000.0);
        this.inquilino = new Inquilino(45L, "55.555.999", "Brian", "Gomez", "Profesor");
    }

    @Override
    public PropiedadInquilinoDTO buscarInforPropietario() {
        PropiedadInquilinoDTO dto = new PropiedadInquilinoDTO(
                                            propiedad.getTipoPropiedad(),
                                            propiedad.getDireccion(),
                                    inquilino.getNombre() + " " + inquilino.getApellido(),
                                            inquilino.getProfesion());

        return dto;
    }
}
