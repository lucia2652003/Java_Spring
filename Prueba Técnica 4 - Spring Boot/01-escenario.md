## Objetivo

El objetivo de este desafío es aplicar los contenidos dados hasta el momento durante el BOOTCAMP (Git, Java, Spring Boot, Testing, JPA + Hibernate, Spring Security) en la implementación de una API REST a partir de un enunciado propuesto, una especificación de requisitos técnico-funcionales y documentación anexada.


## Escenario

Una agencia de turismo desea llevar a cabo el desarrollo de una aplicación que le permita recibir solicitudes de reservas para los diferentes tipos de paquetes que ofrece. Por el momento los dos servicios con los que cuenta son el de búsqueda y reserva de hoteles y búsqueda y reserva de vuelos.

Para ello cuenta con los siguientes datos de **ejemplo/referencia (NO TOMARLOS COMO LITERALES)**:


### Datos Hoteles

| Código Hotel | Nombre            | Lugar/Ciudad | Tipo de Habitación | Precio por noche | Disponible Desde | Disponible hasta | Reservado |
| ------------ | ----------------- | ------------ | ------------------ | ---------------- | ---------------- | ---------------- | --------- |
| AR-0002      | Atlantis Resort   | Miami        | Doble              | $630             | 10/02/2024       | 20/03/2024       | NO        |
| AR-0003      | Atlantis Resort 2 | Miami        | Triple             | $820             | 10/02/2024       | 23/03/2024       | NO        |
| RC-0001      | Ritz-Carlton      | Buenos Aires | Single             | $543             | 10/02/2024       | 19/03/2024       | NO        |
| RC-0002      | Ritz-Carlton 2    | Medellín     | Doble              | $720             | 12/02/2024       | 17/04/2024       | NO        |
| GH-0002      | Grand Hyatt       | Madrid       | Doble              | $579             | 17/04/2024       | 23/05/2024       | NO        |
| GH-0001      | Grand Hyatt 2     | Buenos Aires | Single             | $415             | 02/01/2024       | 19/02/2024       | NO        |
| HL-0001      | Hilton            | Barcelona    | Single             | $390             | 23/01/2024       | 23/11/2024       | NO        |
| HL-0002      | Hilton 2          | Barcelona    | Doble              | $584             | 23/01/2024       | 15/10/2024       | NO        |
| MT-0003      | Marriott          | Barcelona    | Doble              | $702             | 15/02/2024       | 27/03/2024       | NO        |
| SH-0004      | Sheraton          | Madrid       | Múltiple           | $860             | 01/03/2024       | 17/04/2024       | NO        |
| SH-0002      | Sheraton 2        | Iguazú       | Doble              | $640             | 10/02/2024       | 20/03/2024       | NO        |
| IR-0004      | InterContinental  | Cartagena    | Múltiple           | $937             | 17/04/2024       | 12/06/2024       | NO        |


### Datos Vuelos

| Nro Vuelo | Origen       | Destino      | Tipo Asiento | Precio por persona | Fecha ida  | Fecha Vuelta |
| --------- | ------------ | ------------ | ------------ | ------------------ | ---------- | ------------ |
| BAMI-1235 | Barcelona    | Miami        | Economy      | $650               | 10/02/2024 | 15/02/2024   |
| MIMA1420  | Miami        | Madrid       | Business     | $4320              | 10/02/2024 | 20/02/2024   |
| MIMA-1420 | Miami        | Madrid       | Economy      | $2573              | 10/02/2024 | 21/02/2024   |
| BABU-5536 | Barcelona    | Buenos Aires | Economy      | $732               | 10/02/2024 | 17/02/2024   |
| BUBA-3369 | Buenos Aires | Barcelona    | Business     | $1253              | 12/02/2024 | 23/02/2024   |
| IGBA-3369 | Iguazú       | Barcelona    | Economy      | $540               | 02/01/2024 | 16/01/2024   |
| BOCA-4213 | Bogotá       | Cartagena    | Economy      | $800               | 23/01/2024 | 05/02/2024   |
| CAME-0321 | Cartagena    | Medellín     | Economy      | $780               | 23/01/2024 | 31/01/2024   |
| BOIG-6567 | Bogotá       | Iguazú       | Business     | $570               | 15/02/2024 | 28/02/2024   |
| BOBA-6567 | Bogotá       | Buenos Aires | Economy      | $398               | 01/03/2024 | 14/03/2024   |
| BOMA-4442 | Bogotá       | Madrid       | Economy      | $1100              | 10/02/2024 | 24/02/2024   |
| MEMI-9986 | Medellín     | Miami        | Business     | $1164              | 17/04/2024 | 02/05/2024   |

📝 A partir de esta información brindada por la agencia, un analista funcional llevó a cabo el relevamiento de los requerimientos técnicos funcionales y ha proporcionado una documentación técnico-funcional que se detalla en un documento aparte llamado: **2. Requerimientos Funcionales**

📝 Conociendo estos requerimientos se solicita desarrollar la API correspondiente para lograr la consulta y reserva tanto de hoteles como de vuelos con los que trabaja la agencia. Cabe destacar que el desarrollador puede proponer mejoras que considere necesarias a este relevamiento llevado a cabo siempre y cuando estén justificadas o especificadas como supuestos.

## Condiciones de Entrega

- **Código fuente** de la aplicación en un repositorio de control de versiones (GitHub).
    
    - Utilizar como formato de **nombre del repositori**o la siguiente combinación: apellido+nombre+_pruebatec4. Ej: **gomezbrian_pruebatec4**
        
- Un informe o documentación breve que describa cómo ejecutar y probar la aplicación. En caso de que algunos requerimientos no estén claros en la presente documentación, se permite el uso de SUPUESTOS. Esto puede ser incluido en el archivo **README** de **GitHub**.
    
- Documentación de los endpoints mediante Swagger.
    
- Fecha de entrega máxima **Jueves 27/02/2025** a las **23:59 hora España**
    
- Base de datos de referencia en formato .sql en la carpeta raiz del proyecto.
    
- Colecciones de Postman para pruebas en la carpeta raiz del proyecto.
    

