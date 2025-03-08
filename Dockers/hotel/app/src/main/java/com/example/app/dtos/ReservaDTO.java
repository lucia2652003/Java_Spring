package com.example.app.dtos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor @NoArgsConstructor
public class ReservaDTO {

    @JsonProperty("idReserva")
    private Long identificadorReserva;

    @JsonProperty("fechaInicio")
    private LocalDateTime fechaIN;

    @JsonProperty("fechaFin")
    private LocalDateTime fechaFN;

    @JsonProperty("numHabitacion")
    private Integer hab;

    @JsonBackReference
    @JsonProperty("clienteId")
    private ClienteDTO cliente;

    @JsonProperty("cliente_asociado")
    private String nombreCliente;

}
