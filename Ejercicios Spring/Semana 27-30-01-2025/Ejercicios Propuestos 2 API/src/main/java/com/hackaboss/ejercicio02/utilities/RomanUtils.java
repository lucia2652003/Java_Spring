package com.hackaboss.ejercicio02.utilities;

public class RomanUtils {
    public static String validarNumRomano(int numero){
        final int MAX = 5000, MIN = 1;
        if(numero < MIN || numero > MAX){
            return "El numero "+numero+" debe estar entre el "+MIN+" y "+MAX;
        }

        return convertirNumeroRomano(numero);
    }

    public static String convertirNumeroRomano(int num){
        int [] valoresEnteros = {1000, 900, 500, 400, 100 , 90, 50, 40, 10, 9, 5, 4, 1};

        String[] valoresRomanos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder resultado = new StringBuilder();
        int indice = 0;

        while(num > 0){
            if(num >= valoresEnteros[indice]){
                resultado.append(valoresRomanos[indice]);
                num -= valoresEnteros[indice];
            }else{
                indice += 1;
            }
        }

        return resultado.toString();
    }
}
