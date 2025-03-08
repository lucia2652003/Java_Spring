package com.hackaboss.app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UsuarioRespuesta {

    @JsonProperty("datoRecibido")
    private String prametroRecibido;

    @JsonProperty("datoEnviado")
    private String prametroEnviado;

    @JsonIgnore
    private String status;

    public UsuarioRespuesta() {
    }

    public UsuarioRespuesta(String prametroRecibido, String prametroEnviado, String status) {
        this.prametroRecibido = prametroRecibido;
        this.prametroEnviado = prametroEnviado;
        this.status = status;
    }

    public String getPrametroRecibido() {
        return prametroRecibido;
    }

    public void setPrametroRecibido(String prametroRecibido) {
        this.prametroRecibido = prametroRecibido;
    }

    public String getPrametroEnviado() {
        return prametroEnviado;
    }

    public void setPrametroEnviado(String prametroEnviado) {
        this.prametroEnviado = prametroEnviado;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UsuarioRespuesta{" +
                "prametroRecibido='" + prametroRecibido + '\'' +
                ", prametroEnviado='" + prametroEnviado + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
