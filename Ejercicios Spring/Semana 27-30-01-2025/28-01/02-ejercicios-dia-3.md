### Ejercicio Nº 1: Conversor de unidades de longitud

Realiza una API que sea capaz de convertir de centímetros a metros. Para ello, se deberá enviar como parámetro mediante una solicitud GET la cantidad de centímetros y la API por su parte deberá devolver como respuesta su equivalente en metros.

- **Por ejemplo:** Si el parámetro es 163, la API debe devolver 1,63.
    
- Puedes también agregar mensajes instructivos para que la respuesta sea más atractiva. Por ejemplo: “El equivalente a 163 cm es de 1,63 metros”


### Ejercicio Nº 2: Desafío del código Morse

**Dificultad del ejercicio** ⭐⭐⭐⭐⭐ ¿Te animas a resolverlo?

El **sistema Morse** permite cifrar cada grafema del alfabeto como una secuencia de "puntos" y "rayas" o “líneas”. Por ejemplo, la letra S se cifra como · · ·, la letra T se cifra como − y el número 7 se cifra como · · - - -

El **código Morse** no hace diferencia entre mayúsculas y minúsculas, sin embargo sus conversiones comúnmente se presentan en letras en mayúscula (por convención). Al redactar el mensaje un código Morse, se utiliza un solo espacio para separar los códigos de grafemas y se emplean 3 espacios para separar palabras.

En base a esto, realizar una API que sea capaz de descifrar SOLO PALABRAS (no frases) de nuestro alfabeto a código morse. Para ello, el sistema deberá tener en cuenta la siguiente tabla de valores de conversión:

#### Letras

| Caracter | Código Morse | Caracter | Código Morse |
| -------- | ------------ | -------- | ------------ |
| A        | · -          | N        | - ·          |
| B        | - · · ·      | O        | - - -        |
| C        | - · - ·      | P        | · - - ·      |
| D        | - · ·        | Q        | - - · -      |
| E        | ·            | R        | · - ·        |
| F        | · · - ·      | S        | · · ·        |
| G        | - - ·        | T        | -            |
| H        | · · · ·      | U        | · · -        |
| I        | · ·          | V        | · · · -      |
| J        | · - - -      | W        | · - -        |
| K        | - · -        | X        | - · · -      |
| L        | · - · ·      | Y        | - · - -      |
| M        | - -          | Z        | - - · ·      |

#### Números

| Caracter | Código Morse | Caracter | Código Morse |
| -------- | ------------ | -------- | ------------ |
| 0        | - - - - -    | 5        | · · · · ·    |
| 1        | · - - - -    | 6        | - · · · ·    |
| 2        | · · - - -    | 7        | - - · · ·    |
| 3        | · · · - -    | 8        | - - - · ·    |
| 4        | · · · · -    | 9        | - - - - ·    |

#### Ejemplos de conversiones

| Palabra  | Código Morse                          |
| -------- | ------------------------------------- |
| código   | -.-. --- --.. .. -.. ---              |
| bootcamp | -... --- --- - .-.-.- -.-. .- -- .--. |
| java     | .--- .- ...- .-                       |


### Ejercicio Nº 3: Palabras Morse - **Extra (Opcional)**

Como desafío **extra** y **OPCIONAL (no obligatorio)** te proponemos que logres que tu ejercicio anterior sea capaz de, además de traducir palabras en código morse, sea capaz de traducir frases completas.

Recuerda que en el código Morse la separación de palabras se realiza mediante 3 espacios en blanco.

**⭐ ¿Te animas a resolverlo?**

---

## Resoluciones

📌 Recuerda que las resoluciones estarán habilitadas el último día de la semana luego de la revisión en la clase en vivo.

📌 Asegúrate de haber resuelto y subido tus resoluciones propias a tu repositorio antes de que se habiliten las resoluciones semanales.

