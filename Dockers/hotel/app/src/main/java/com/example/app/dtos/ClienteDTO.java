package com.example.app.dtos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    @JsonProperty("codigoCliente")
    private Long identificadorCliente;

    private String nombre;

    @JsonProperty("primerApellido")
    private String apellido;

    @JsonProperty("DNI")
    private String dni;

    private String nacion;

    private String correo;

    @JsonProperty("telefono")
    private Integer mobil;

    @JsonManagedReference
    @JsonProperty("susReservas")
    private List<ReservaDTO> reservas;

}
