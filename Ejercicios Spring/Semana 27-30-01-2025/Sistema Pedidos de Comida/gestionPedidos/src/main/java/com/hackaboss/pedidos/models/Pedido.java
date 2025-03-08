package com.hackaboss.pedidos.models;

import java.util.List;

public class Pedido {
    private Long id;
    private String nombre;
    private List<Plato> pedidos;

    public Pedido() {
    }

    public Pedido(Long id, String nombre, List<Plato> listado) {
        this.id = id;
        this.nombre = nombre;
        this.pedidos = listado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Plato> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Plato> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", listado=" + pedidos +
                '}';
    }
}
