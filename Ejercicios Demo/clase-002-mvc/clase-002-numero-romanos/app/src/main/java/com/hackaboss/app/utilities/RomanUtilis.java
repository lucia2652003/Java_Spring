package com.hackaboss.app.utilities;

public class RomanUtilis {

    public static String validarNumeroRomano(int numeroDecimal){
        final Integer MAX = 5000;
        final Integer MIN = 1;
        if (numeroDecimal < MIN || numeroDecimal > MAX) {
            return "El numero " + numeroDecimal + " no está entre el " + MIN + " y el " + MAX;
        }

        String numeroRomano = convertirNumeroRomano(numeroDecimal);
        return numeroRomano;
    }

    public static String convertirNumeroRomano(int numeroDecimal){

        int[] valoresEnteros =    {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] valoresRomanos =  {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        StringBuilder resultado = new StringBuilder();
        int indice = 0;

        while(numeroDecimal > 0){
            if (numeroDecimal >= valoresEnteros[indice]) {
                resultado.append(valoresRomanos[indice]);
                numeroDecimal -= valoresEnteros[indice];
            }else{
                indice++;
            }
        }

        return resultado.toString();
    }
}
