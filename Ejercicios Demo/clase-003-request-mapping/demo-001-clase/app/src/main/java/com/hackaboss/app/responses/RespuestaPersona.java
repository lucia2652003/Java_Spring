package com.hackaboss.app.responses;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class RespuestaPersona {


    private String mensaje;
    private Integer estado;
    @JsonIgnore
    private String metodo;

    public RespuestaPersona() {
    }

    public RespuestaPersona(String mensaje, Integer estado, String metodo) {
        this.mensaje = mensaje;
        this.estado = estado;
        this.metodo = metodo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    @Override
    public String toString() {
        return "RespuestaPersona{" +
                "mensaje='" + mensaje + '\'' +
                ", estado=" + estado +
                ", metodo='" + metodo + '\'' +
                '}';
    }
}
