package com.hackaboss.pedidos.responses;

public class RespuestaPlato {
    private String mensaje;
    private Integer status;
    private String metodo;

    public RespuestaPlato() {
    }

    public RespuestaPlato(String mensaje, Integer status, String metodo) {
        this.mensaje = mensaje;
        this.status = status;
        this.metodo = metodo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    @Override
    public String toString() {
        return "RespuestaPlato{" +
                "mensaje='" + mensaje + '\'' +
                ", status=" + status +
                ", metodo='" + metodo + '\'' +
                '}';
    }
}
