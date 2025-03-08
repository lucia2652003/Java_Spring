### Ejercicio Nº 1: **Plataforma de Gestión de Eventos Académicos**

Estás desarrollando una plataforma para la gestión de eventos académicos en una universidad. El objetivo es crear una API RESTful utilizando Java con Spring Boot que permita a los usuarios ver eventos próximos, registrar nuevos eventos, inscribir participantes en eventos y obtener detalles específicos de un evento.

Para lograrlo, se requiere implementar los siguientes endpoints:

1. **GET /eventos:** Devuelve una lista de todos los eventos académicos próximos.
    
2. **GET /evento/{id}:** Obtiene información detallada de un evento específico mediante su ID.
    
3. **POST /evento:** Permite a los usuarios crear un nuevo evento académico y almacenarlo en una lista.


>💡**Nota:** Utilizar como base de datos una Collection a elección para evitar todavía la configuración de Bases de Datos.

Una vez implementados los endpoints, lleva a cabo pruebas con Postman para verificar que cada uno funcione correctamente. Al finalizar, exporta la colección de Postman que contiene las pruebas realizadas.

#### Ejemplo de JSON para pruebas de POST

```json
{
  "titulo": "Conferencia de Ciencias Computacionales",
  "descripcion": "Una conferencia sobre los avances en inteligencia artificial y aprendizaje automático.",
  "fecha": "2023-12-15",
  "hora": "10:00",
  "lugar": "Aula Magna Centro del Conocimiento",
  "ponente": "Dr. Esteban Madrazzo"
}
```

---

## Resoluciones

📌 Recuerda que las resoluciones estarán habilitadas el último día de la semana luego de la revisión en la clase en vivo.

📌 Asegúrate de haber resuelto y subido tus resoluciones propias a tu repositorio antes de que se habiliten las resoluciones semanales.

