package com.example.ejercicio.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutoDTO {

    private Long identificador;

    @JsonProperty("brandAuto")
    private String marcaAuto;

    @JsonProperty("modelAuto")
    private String modeloAuto;

    @JsonProperty("kilometers")
    private Integer kmAuto;

    @JsonProperty("doorsAuto")
    private Integer puertasAuto;

    @JsonProperty("priceAuto")
    private Integer precioAuto;
}
