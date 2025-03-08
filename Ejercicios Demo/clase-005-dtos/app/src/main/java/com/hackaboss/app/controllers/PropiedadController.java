package com.hackaboss.app.controllers;

import com.hackaboss.app.dtos.PropiedadInquilinoDTO;
import com.hackaboss.app.services.PropiedadServiceInterfaz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/propiedad")
public class PropiedadController {

    //inyeccion de dependencia de un servicio
    /*todo: mediante auto cableado - NO APLICAN PRUEBAS UNITARIAS*/
    @Autowired
    PropiedadServiceInterfaz propiedadServiceInterfaz;

    /* todo: mediante setters - MENOS RECOMENDADO
    @Autowired
    public void setPropiedadServiceInterfaz(PropiedadServiceInterfaz propiedadServiceInterfaz) {
        this.propiedadServiceInterfaz = propiedadServiceInterfaz;
    }*/

    /* todo: mediante constructor - SI APLICAN PRUEBAS UNITARIAS
    public PropiedadController(PropiedadServiceInterfaz propiedadServiceInterfaz) {
        this.propiedadServiceInterfaz = propiedadServiceInterfaz;
    }*/

    @GetMapping("/info")
    public ResponseEntity obtenerInfoInquilino(){
        PropiedadInquilinoDTO info = propiedadServiceInterfaz.buscarInforPropietario();
        return ResponseEntity.status(200).body(info);
    }
}
