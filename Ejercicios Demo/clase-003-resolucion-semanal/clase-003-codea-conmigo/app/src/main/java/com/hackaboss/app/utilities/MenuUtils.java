package com.hackaboss.app.utilities;

import com.hackaboss.app.entities.Platillo;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class MenuUtils {
    private final String TIPO_MENU_VEGETARIANO = "vegetariano";
    private final String TIPO_MENU_CARNIVORO = "carnivoro";



    private List<Platillo> menu;

    public MenuUtils() {
        this.menu = new ArrayList<>();
        this.menu.add(new Platillo(1L, "Plato Vegetariano #1", "Lechuga y zanahoria", 20.00, TIPO_MENU_VEGETARIANO));
        this.menu.add(new Platillo(2L, "Plato Vegetariano #2", "Lechuga y zanahoria y limon", 20.00, TIPO_MENU_VEGETARIANO));
        this.menu.add(new Platillo(3L, "Plato Vegetariano #3", "Lechuga y zanahoria y tomate", 20.00, TIPO_MENU_VEGETARIANO));
        this.menu.add(new Platillo(4L, "Plato Carnivoro #1", "Pollo y arroz", 25.00, TIPO_MENU_CARNIVORO));
        this.menu.add(new Platillo(5L, "Plato Carnivoro #2", "Carne y papas fritas", 25.00, TIPO_MENU_CARNIVORO));
        this.menu.add(new Platillo(6L, "Plato Carnivoro #3", "Salmon y papas", 25.00, TIPO_MENU_CARNIVORO));
    }

    public ResponseEntity findAll(String tipoMenu) {

        if (tipoMenu == null) return ResponseEntity.status(200).body(this.menu);
                else  return ResponseEntity.status(200)
                                            .body(this.menu.stream()
                                                            .filter(platillo -> platillo.getTipoMenu().equalsIgnoreCase(tipoMenu))
                                                            .toList());
    }

    public ResponseEntity createPlatillo(Platillo platillo) {
            platillo.setId(this.menu.size() + 1L);
            this.menu.add(platillo);
            return ResponseEntity.status(HttpStatus.CREATED).body(platillo);
    }

    public Platillo encontrarPlatillo(Long idPlatilloBuscado){
        return this.menu.stream().filter(platillo -> platillo.getId() == idPlatilloBuscado).findFirst().orElse(null);
    }


}
