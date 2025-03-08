package com.hackaboss.holaMundo.entities;

public class Usuario {
    private Long id;
    private String name;
    private String lasName;

    public Usuario() {
    }

    public Usuario(Long id, String name, String lasName) {
        this.id = id;
        this.name = name;
        this.lasName = lasName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLasName() {
        return lasName;
    }

    public void setLasName(String lasName) {
        this.lasName = lasName;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lasName='" + lasName + '\'' +
                '}';
    }
}
