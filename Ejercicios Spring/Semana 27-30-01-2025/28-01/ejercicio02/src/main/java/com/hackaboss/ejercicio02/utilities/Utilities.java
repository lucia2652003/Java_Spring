package com.hackaboss.ejercicio02.utilities;

import java.util.HashMap;
import java.util.Map;

public class Utilities {

    public static Map<Character, String> obtenerAlfabetoMorse(){
        Map<Character, String> listadoMorse = new HashMap<>();

        //Alfabeto Morse
        listadoMorse.put('A',"·-");
        listadoMorse.put('B',"-···");
        listadoMorse.put('C',"-·-·");
        listadoMorse.put('D',"-··");
        listadoMorse.put('E', "·");
        listadoMorse.put('F',"··-·");
        listadoMorse.put('G',"--·");
        listadoMorse.put('H', "····");
        listadoMorse.put('I',"··");
        listadoMorse.put('J',"·---");
        listadoMorse.put('K',"-·-");
        listadoMorse.put('L',"·-··");
        listadoMorse.put('M',"--");
        listadoMorse.put('N',"-·");
        listadoMorse.put('O',"---");
        listadoMorse.put('P',"·--·");
        listadoMorse.put('Q',"--·-");
        listadoMorse.put('R',"·-·");
        listadoMorse.put('S',"···");
        listadoMorse.put('T',"-");
        listadoMorse.put('U',"··-");
        listadoMorse.put('V',"···-");
        listadoMorse.put('W',"·--");
        listadoMorse.put('X',"-··-");
        listadoMorse.put('Y',"-··-");
        listadoMorse.put('Z',"-··-");
        listadoMorse.put('0',"-----");
        listadoMorse.put('1',"·----");
        listadoMorse.put('2',"··---");
        listadoMorse.put('3',"···--");
        listadoMorse.put('4',"····-");
        listadoMorse.put('5',"·····");
        listadoMorse.put('6',"-····");
        listadoMorse.put('7',"--···");
        listadoMorse.put('8',"---··");
        listadoMorse.put('9',"----·");

        return listadoMorse;
    }

    public static String textoAMorse(String key){
        Map<Character, String> morse = obtenerAlfabetoMorse();
        StringBuilder palabraMorse = new StringBuilder();

        if(key == null || key.isEmpty()){
            return "No hay caracteres, no se puede hacer la inversión";
        }

        //Dividir el word separados [-,-,-,-,...]
        String[] palabras = key.toUpperCase().split(" ");

        for (int i = 0; i < palabras.length; i++) {
            String pal = palabras[i];

            for(char caracteres: pal.toCharArray()){
                String codigoMorse = morse.get(caracteres);
                if(codigoMorse != null) { //Si existe ese carácter en el Map
                    palabraMorse.append(codigoMorse).append(" "); //Lo sustituye por el carácter morse
                }
            }

            if(i < palabras.length - 1) palabraMorse.append(" / ");
        }// fin for
        
        return palabraMorse.toString();
    }
}
