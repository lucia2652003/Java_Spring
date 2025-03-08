## Ejercicio Nº 1

Crear una API que gestione los datos de estudiantes de una universidad y que devuelva una lista ordenada de acuerdo con su rendimiento académico en la materia “Programación I” (calculado en forma de promedio).

Implementar para esto una arquitectura de múltiples capas, destacando la capa **service**, para procesar y analizar los datos de los estudiantes.

Enfocarse en la lógica de negocio para evaluar el rendimiento académico, pudiendo involucrar la capa **model** para representar los datos de los estudiantes.

- De cada estudiante se solicitan los siguientes datos: num_matricula, nombre, apellido, fecha de nacimiento.
    
- Para las calificaciones se necesita una clase Calificacion, la cual almacena las 3 calificaciones que obtuvo cada estudiante en los exámenes de la materia “Programación I” y su promedio. Tener en cuenta que cada estudiante tiene **uno y solo un** registro de calificaciones asociado.
    
    - En la clase calificación se debe guardar: id, calificacion1, calificacion2, calificacion3, promedio, Alumno un Alumno.
        

En la capa controller deberán existir los siguientes endpoints:

- **GET /estudiantes:** Devuelve una lista de todos los estudiantes sin un orden particular.
    
- **GET /calificaciones/{num_matricula}:** Devuelve las calificaciones de un determinado estudiante.
    
- **GET /calificaciones/ordendesc:** Devuelve las calificaciones de todos los estudiantes, junto con el nombre de cada uno de ellos ordenados de forma descendente (mayor calificación primero, menor a lo último)


>💡En caso de que ya conozcas el **patrón DTO**, puedes aplicarlo en esta consigna 😉

---

## Resoluciones

📌 Recuerda que las resoluciones estarán habilitadas el último día de la semana luego de la revisión en la clase en vivo.

📌 Asegúrate de haber resuelto y subido tus resoluciones propias a tu repositorio antes de que se habiliten las resoluciones semanales.

