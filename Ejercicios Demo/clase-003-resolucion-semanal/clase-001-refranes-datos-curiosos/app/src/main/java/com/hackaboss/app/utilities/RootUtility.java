package com.hackaboss.app.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RootUtility {

    public static List<String> recuperarListadoDeFrases(){
        List<String> frases = new ArrayList<>();
        frases.add("1. Esta es una frase aleatoria");
        frases.add("2. Esta es una frase aleatoria");
        frases.add("3. Esta es una frase aleatoria");
        frases.add("4. Esta es una frase aleatoria");
        frases.add("5. Esta es una frase aleatoria");
        return frases;
    }

    public static List<String> recuperarListadoDeDatos(){
        List<String> datosCuriosos = new ArrayList<>();
        datosCuriosos.add("1. Esta es un Dato curioso");
        datosCuriosos.add("2. Esta es un Dato curioso");
        datosCuriosos.add("3. Esta es un Dato curioso");
        datosCuriosos.add("4. Esta es un Dato curioso");
        datosCuriosos.add("5. Esta es un Dato curioso");
        return datosCuriosos;
    }

    public static String obtenerElementoRandom(List<String> listado){
        // metodo random
        int aleatorio = new Random().nextInt(listado.size());
        return listado.get(aleatorio);
    }

}
