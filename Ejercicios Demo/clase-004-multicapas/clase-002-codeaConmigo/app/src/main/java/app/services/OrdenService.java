package app.services;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class OrdenService implements OrdenServiceInterfaz{
    @Override
    public List<String> ordenamientoNombre(List<String> listaNombres) {
        //Collections.sort(listaNombres);
        Collections.sort(listaNombres, Comparator.reverseOrder());
        listaNombres.sort(Comparator.reverseOrder());
        return listaNombres;
    }
}
