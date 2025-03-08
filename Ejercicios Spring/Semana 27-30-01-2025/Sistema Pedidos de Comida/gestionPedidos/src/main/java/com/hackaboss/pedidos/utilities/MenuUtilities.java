package com.hackaboss.pedidos.utilities;

import com.hackaboss.pedidos.models.Plato;
import com.hackaboss.pedidos.responses.RespuestaPlato;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class MenuUtilities {

    private List<Plato> menus;

    private String VEGETARIANO = "vegetariano";
    private String CARNIVORO = "carnivoro";

    public MenuUtilities() {
        this.menus = new ArrayList<>();
        this.menus.add(new Plato(1L, "Plato Vegetariano #1", "Crema Calabaza", 18.02F,VEGETARIANO));

    }


    public ResponseEntity filtrarMenus(String tipoMenu) {

        if(tipoMenu.isEmpty()) return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("No se ha podido realizar la búsqueda");

        else return ResponseEntity.status(200).body(this.menus.stream()
                .filter(plato -> plato.getTipoMenu().equalsIgnoreCase(tipoMenu))
                .toList());
    }

    public RespuestaPlato agregarPlato(Plato plato) {
        try {
            plato.setId(this.menus.size() +1L);
            this.menus.add(plato);
            return new RespuestaPlato("Añadido el plato", 200, "OK - POST");
        } catch (Exception e) {
            return new RespuestaPlato(e.getMessage(), 500, "OK - Error");
        }
    }

    public Plato encontrarPlato(Long id){
        return this.menus.stream()
                         .filter(menu -> menu.getId() == id)
                         .findFirst()
                         .orElse(null);
    }
}
