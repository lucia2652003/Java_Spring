package com.hackaboss.app.entities;

import java.util.List;

public class Menu {
    private Long id;
    private List<Platillo> platillos;

    public Menu(Long id, List<Platillo> platillos) {
        this.id = id;
        this.platillos = platillos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Platillo> getPlatillos() {
        return platillos;
    }

    public void setPlatillos(List<Platillo> platillos) {
        this.platillos = platillos;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", platillos=" + platillos +
                '}';
    }
}
