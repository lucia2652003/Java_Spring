package com.hackaboss.app.entities;

import java.util.List;

public class Pedido {

    private Long id;
    private String nombre;
    private List<Platillo> pedidos;

    public Pedido(Long id, String nombre, List<Platillo> pedidos) {
        this.id = id;
        this.nombre = nombre;
        this.pedidos = pedidos;
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

    public List<Platillo> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Platillo> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", pedidos=" + pedidos +
                '}';
    }
}
