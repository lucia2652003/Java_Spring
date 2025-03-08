## API HOTEL ##

Esta aplicación se realizará los registros de las reservas que presenta el hotel. 
Para eso realizaremos operaciones CRUD (crear, leer, actualizar y eliminar) empleando Spring un framework que me 
ofrece las dependencias de seguridad, conexión a la base de datos, documentación y pruebas unitarias. 

También se aplicará el Docker una herramienta que empaqueta 
la aplicación y la ejecuta creando una DB en el servidor.

## ¿Como ejecutarlo? ##

Una vez comprobado las variables de entorno, conexiones y demás. 
Debemos tener abierto el Docker y el cmd de windows (si lo instalaste como administrado "Ejecutar como administrador")
Una vez hecho vamos al directorio donde está el docker-compose.yml, lo construiremos y lo ejecutamos

````
   cd Directorio donde esta docker-compose.yml app
   docker-compose build
   docker-compose up
````

Debe aparecer dos imágenes una mysql y otra de la app. 
Abrimos el Postman con las colecciones correspondientes y empezamos a enviar peticiones.

En los métodos POST se requieren de autenticación, Authorization > 'Auth Type : Basic Auth'
usuario: drax182 y password: x845fg4.

Si vas a localhost:8080/documentacion te mostrará los diferentes endpoints si quieres probarlos pulsa 'Try it out'
que se encuentra a la derecha y luego ejecuta 'Execute'.

