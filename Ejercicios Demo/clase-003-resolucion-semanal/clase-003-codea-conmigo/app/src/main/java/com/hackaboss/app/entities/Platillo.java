package com.hackaboss.app.entities;

public class Platillo {
    private Long id;
    private String nombre;
    private String ingredientes;
    private double precio;
    private String tipoMenu;

    public Platillo(Long id, String nombre, String ingredientes, double precio, String tipoMenu) {
        this.id = id;
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.precio = precio;
        this.tipoMenu = tipoMenu;
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

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTipoMenu() {
        return tipoMenu;
    }

    public void setTipoMenu(String tipoMenu) {
        this.tipoMenu = tipoMenu;
    }

    @Override
    public String toString() {
        return "Platillo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", ingredientes='" + ingredientes + '\'' +
                ", precio=" + precio +
                ", tipoMenu='" + tipoMenu + '\'' +
                '}';
    }
}
