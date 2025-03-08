package com.hackaboss.ejercicio01.servicies;

import com.hackaboss.ejercicio01.dtos.PlatoDTO;
import com.hackaboss.ejercicio01.models.Ingrediente;
import com.hackaboss.ejercicio01.models.Plato;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PlatoService implements IPlatoService{

    private List<Plato> restaurante;

    public PlatoService() {
        this.restaurante = new ArrayList<>();

        this.restaurante.add(new Plato(1L, "Carrot Cake", 18.52,
                              List.of(new Ingrediente(1L, "Zanahoria", 75.05),
                                      new Ingrediente(2L, "Harina", 364.02))));

        this.restaurante.add(new Plato(2L, "Hamburguesa vegana", 7.05,
                List.of(new Ingrediente(1L, "Espinacas", 55.88),
                        new Ingrediente(2L, "Cebolla", 36.02),
                        new Ingrediente(3L, "Lechuga", 15.36))));
    }

    @Override
    public PlatoDTO buscarPlato(String nombre) {
        //Encontrar el plato
        Plato buscado = this.restaurante.stream()
                .filter(plato -> plato.getNombrePlato().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);

        PlatoDTO platoDTO = new PlatoDTO();

        platoDTO.setTotalCalorias(calcularTotalCalorias(buscado));
        platoDTO.setListaIngredientes(creacionListaIng(buscado));
        platoDTO.setIngredienteMax(buscarIngredienteCalMax(buscado));

        return platoDTO;
    }

    private double calcularTotalCalorias(Plato buscado) {
        return buscado.getIngredientes().stream()
                .map(Ingrediente::getCalorias)
                .reduce(Double::sum)
                .stream()
                .findFirst()
                .orElse(0.0);
    }

    private Map<String, Double> creacionListaIng(Plato buscado) {
        Map<String, Double> listaIng = new HashMap<>();
        buscado.getIngredientes().forEach(ingrediente ->{
            listaIng.put(ingrediente.getNombreIngrediente(), ingrediente.getCalorias());
        });
        return listaIng;
    }

    private Ingrediente buscarIngredienteCalMax(Plato buscado) {
        //Encontrar calorías máximas
        double caloriasMax = buscado.getIngredientes().stream()
                .map(Ingrediente::getCalorias)
                .max(Double::compare)
                .orElse(0.0);

        return buscado.getIngredientes().stream()
                .filter(ingrediente -> ingrediente.getCalorias().equals(caloriasMax))
                .findFirst()
                .orElse(null);
    }
}
