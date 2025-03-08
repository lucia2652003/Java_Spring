package com.hackaboss.prueba_dtos.controllers;

import com.hackaboss.prueba_dtos.service.IPropiedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/propiedad")
public class PropiedadControllers {

    //inyección de dependencias de un servicio
    @Autowired
    IPropiedadService iPropiedadService;

    /*
    * //Aplicando setter
    * @Autowired
    * public void setiPropiedadService(IPropiedadService iPropiedadService) {
    *    this.iPropiedadService = iPropiedadService;
    * }
    *
    * */

    /*
    * //Con constructor
    * public IPropiedadControllers(IPropiedadService iPropiedadService) {
    *    this.iPropiedadService = iPropiedadService;
    * }
    * */

    @GetMapping("")
    public ResponseEntity obtenerInfoInquilino(){
        return ResponseEntity.status(200).body(iPropiedadService.buscarInfoInquilino());
    }
}
