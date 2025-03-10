package com.hackaboss.app.utilities;

import java.util.Map;

public class ConvertirdorMorseUtils {

    private static final Map<Character, String> mapaDeCaracteres = Map.ofEntries(
            Map.entry('A', ".-"),
            Map.entry('B', "-..."),
            Map.entry('C', "-.-."),
            Map.entry('D', "-.."),
            Map.entry('E', "."),
            Map.entry('F', "..-."),
            Map.entry('G', "--."),
            Map.entry('H', "...."),
            Map.entry('I', ".."),
            Map.entry('J', ".---"),
            Map.entry('K', "-.-"),
            Map.entry('L', ".-.."),
            Map.entry('M', "--"),
            Map.entry('N', "-."),
            Map.entry('O', "---"),
            Map.entry('P', ".--."),
            Map.entry('Q', "--.-"),
            Map.entry('R', ".-."),
            Map.entry('S', "..."),
            Map.entry('T', "-"),
            Map.entry('U', "..-"),
            Map.entry('V', "...-"),
            Map.entry('W', ".--"),
            Map.entry('X', "-..-"),
            Map.entry('Y', "-.--"),
            Map.entry('Z', "--.."),
            Map.entry('0', "-----"),
            Map.entry('1', ".----"),
            Map.entry('2', "..---"),
            Map.entry('3', "...--"),
            Map.entry('4', "....-"),
            Map.entry('5', "....."),
            Map.entry('6', "-...."),
            Map.entry('7', "--..."),
            Map.entry('8', "---.."),
            Map.entry('9', "----."),
            Map.entry(' ', " / ")
    );
    public static String textoAMorse(String key) {
        //"Hola brian"
        if (key == null || key.isEmpty()) return " ";

        StringBuilder morseBiulder = new StringBuilder();
        //dividir la key en palabras   hola brian como estas
        String[] palabras = key.toUpperCase().split(" ");

        for (int i = 0; i < palabras.length ; i++) {
            String palabra = palabras[i];
            //"hola" ---- "brian"
            for (char caracteres : palabra.toCharArray()) {
                //[h,o,l,a]
                String codigoMorse = mapaDeCaracteres.get(caracteres);
                // ....
                if (codigoMorse != null) {
                    morseBiulder.append(codigoMorse).append(" ");
                }
            }

            if (i < palabras.length - 1) morseBiulder.append(" / ");
                    else morseBiulder.append("");
        }

        return morseBiulder.toString();
    }
}
