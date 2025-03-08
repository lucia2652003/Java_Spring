package com.hackaboss.ejercicio.entities;

public class Ponente {
    private Long id;
    private String nombre;

    public Ponente() {
    }

    public Ponente(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    @Override
    public String toString() {
        return "Ponente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
