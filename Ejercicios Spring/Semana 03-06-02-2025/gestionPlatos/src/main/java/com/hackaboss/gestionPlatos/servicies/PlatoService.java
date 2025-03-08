package com.hackaboss.gestionPlatos.servicies;

import com.hackaboss.gestionPlatos.dtos.PlatoIngredienteDTO;
import com.hackaboss.gestionPlatos.models.Ingrediente;
import com.hackaboss.gestionPlatos.models.Plato;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlatoService implements IPlatoService{

    private List<Plato> platillos;

    public PlatoService() {
        this.platillos = new ArrayList<>();

        this.platillos.add(new Plato(1L, "Pastel Biarritz", 12.45F,
                List.of(new Ingrediente(23L, "Harina", false))
        ));

        this.platillos.add(new Plato(2L, "Carrot Cake", 15.36F,
                List.of(new Ingrediente(7L, "Canela molida", true),
                        new Ingrediente(12L, "Levadura química sin gluten", true))));

    }

    @Override
    public PlatoIngredienteDTO mostrarPlato(Long id) {

        Plato plato = this.platillos.stream()
                                 .filter(plato1 -> plato1.getId().equals(id))
                                 .findFirst()
                                 .orElse(null);

        //Si encuentra todos que son celiacos es Apto, de lo contrario no
        boolean celiaco = plato.getIngredientes().stream()
                        .allMatch(Ingrediente::getCeliaco);

        PlatoIngredienteDTO platoIngredienteDTO = new PlatoIngredienteDTO();
        platoIngredienteDTO.setNombrePlato(plato.getNombrePlato());
        platoIngredienteDTO.setCeliaco(celiaco);

        return platoIngredienteDTO;
    }
}
