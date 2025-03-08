# 🚀 Guía para Descargar e Instalar Docker en Windows y Desplegar una Aplicación Spring Boot

## 1️⃣ Descarga e Instalación de Docker 🐳

1. 🔗 Ve a la página oficial de Docker: [https://www.docker.com/](https://www.docker.com/products/docker-desktop/)
2. 🔍 Busca a mitad de la pagina el boton de **Download Docker Desktop**.
3. 🖥️ Descarga **Download for Windows - AMD64**.
4. 📂 Abre el instalador descargado y sigue las instrucciones:
   - Si aparece este mensaje: **activar la opción "Use WSL 2 based engine" si tienes WSL 2 instalado.** activalo con el check
   - Sino OK o Siguiente.
5. ✅ Una vez instalado, reinicia tu computadora si es necesario.
6. 🚦 Abre Docker Desktop y verifica que está corriendo correctamente.
7. Ir a Administrador de Tareas: clic derecho en la barra inferior, Administrador de Tareas -> Rendimiento.
8. 🚦 Debe estar habilitada la virtualización.

![Logo de Google](https://support.bluestacks.com/hc/article_attachments/29499674569485)


## 2️⃣ Verificar la Instalación

Ejecuta el siguiente comando en **PowerShell** o en la **línea de comandos** para verificar que Docker está instalado correctamente:

```sh
docker --version
```

Si ves una versión de Docker impresa en la terminal, significa que la instalación fue exitosa. 🎉

---


## 3️⃣ Iniciar Docker Desktop

1. Abrir Docker Desktop- > Skip sin registrarse.
2. What's your role? Cual es tu Rol? -> Desarrollador Back End.
3. What will you use Docker for? Para que usaras Docker? -> Local development

---
### 4 Crear un `Dockerfile` con IntelliJ 📄

Dentro del proyecto de Spring Boot, crea un archivo llamado **`Dockerfile`** en la raíz del proyecto con el siguiente contenido: SI nos dice que si quieres intalar el plugins le damos OK.

Para empezar las configuraciones iremos a nuestro pom.xml y buscaremos las “propiedades” de nuestro proyecto:
Buscamos la etiqueta de versión abajo del artifacId y chequeamos que diga  0.0.1 (dado que será nuestra “primera versión”) y el resto de parámetros los dejamos tal cual.

Nos vamos al  **`Dockerfile`** y agregamos:

```dockerfile
# Usar una imagen base de OpenJDK
FROM openjdk:17-jdk-slim

# direccion del archivo JAR generado con el boton de INSTALL de maven target/nombreAppPom+versionPom
ARG JAR_FILE=target/app-0.0.1-SNAPSHOT.jar

# Esta línea copia el archivo JAR de la ubicación y crea una nuevo llamado app.jar
COPY ${JAR_FILE} app.jar

#Exponer el puerto 8080
EXPOSE 8080

# Definir el comando para ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]
```

---
### 5 Construir Variables de entorno en application.properties 🛠️
1. Chequea la configuración a nuestro archivo application.properties que se llama **`spring.application.name=app`** guardate el nombre.

2. Borra los comentarios ya que cuando ejecutamos los comandos de maven no interpreta los # de los comentarios de este archivo.

3. Asigna las siguiente variables de Entorno.
```xml

spring.datasource.url=${DB_URL}

spring.datasource.username=${DB_USER_NAME}

spring.datasource.password=${DB_PASSWORD}

```

4. Crea los valores de las variables de entorno creadas. Parte superior en Run -> Edit Config -> Variables de entornos -> (+) para agregar una variables y luego su valor en un conjunto <K,V>, asignales datos a las 3 varibales.

5. Asegurate de que arranca la app con las nuevas variables insertadas.

---

### 6 Construir JAR con Maven 🛠️

1. Ten en cuenta que tu aplicacion y los test deben estar corriendo sin problemas. Chequeate si los test son aprobados si utilizas fechas por ejemplo. OJO comenta tu **`AppApplicationTests.java`** comentando la anotación /*@SpringBootTest*/ y el /*@Test	void contextLoads() { }*/ ya que el install lo toma como no aprobado ese test porque no hay nada escrito.

2. Luego asegurate que tienes tu JDK Java 17. File > Project Structure > Project > JDK = 17.

3. Debes ir al apartado de maven al costado derecho. y ejecutar la opcion que dice (M app).

4. Allí buscamos la opción “Lifecycle” y vamos a ejecutar (mediante doble click) la opción clean y luego la opción install.

5. Esto Construira un archivo en la carpeta /app/target llamado **`app-0.0.1-SNAPSHOT.jar`** 

6. Tengamos en cuenta como se llama ese atributo name, en mi caso app. Lo necesitare para la siguiente configuración.

---
### Paso 7 : Definir archivo docker-compose.yml 🏃‍♂️

1. Con nuestro IDE cerrado (para evitar conflictos) vamos a crear un nuevo archivo llamado **`docker-compose.yml`**   fuera de la carpeta raíz de nuestro proyecto, es decir, una carpeta superior/arriba.

2. Desde nuestro explorador de archivos, clic derecho -> Nuevo -> Documento de Texto. No imprta el nombre.

3. Hacemos clic en el archivo de texto creado y se nos va a abrir el bloc de notas.

4. En el bloc de notas, le damos a archivo -> guardar como -> luego completamos los campos:

Nombre: docker-compose.yml

Tipo: Todos los Archivos

5. Darle click a guardar.

6. Agrega el siguiente codigo con la configuracion de tu proyecto

```yml
version: '3'

services:
  app:
    build: app
    mem_limit: 512m
    ports:
      - "8080:8080"
    environment:
      DB_URL: jdbc:mysql://mysql:3306/cursos?createDatabaseIfNotExist=true&serverTimezone=UTC&allowPublicKeyRetrieval=true
      DB_USER_NAME: root
      DB_PASSWORD: ROOT
    restart: always
    depends_on:
      mysql:
          condition: service_healthy
  mysql:
    image: mysql:8.0.21 
    ports:
      - "3307:3306"
    environment:
      MYSQL_ROOT_PASSWORD: ROOT
      MYSQL_PASSWORD: ROOT
      MYSQL_DATABASE: cursos
    restart: always
    healthcheck:
      test: ["CMD", "mysqladmin" ,"ping", "-h", "localhost"]
      timeout: 10s
      retries: 10


```
**`version`**: Indica la versión de docker-compose que se está utilizando. En este caso, se usa la versión '3'.

**`services`** : Define los servicios/imagenes que forman parte de la aplicación.


**`app`**: Es el nombre del servicio que vamos agregar a Docker, este es el name de tu app.properties


**`build: app:`** Indica que se debe construir la imagen Docker para este servicio a partir del contexto en el directorio **`app`**. Esto significa que buscará un Dockerfile dentro del directorio **`app`** para construir la imagen.


**`mem_limit: 512m:`** Establece el límite de memoria para este contenedor en 512 megabytes.

**`ports: - "8080:8080":`** Mapea el puerto 8080 del contenedor al puerto 8080 del host. Esto significa que el servicio **`app`** estará disponible en el puerto 8080 del host donde se ejecuta docker-compos

**`environment`**: aqui van las 3 variables de entorno que creaste en intelliJ pero para que las tenga Docker guardadas. En la URL agregale &allowPublicKeyRetrieval=true esto le dice al conector JDBC que intente obtener reintentar tomar la clave publica para identificar la DB

**`restart: always`**: permite resetear el contenedor de spring o DB siempre que ocurra algun error.

**`depends_on: mysql: condition: service_healthy`**: Asegura que tu aplicación se inicie solamente cuando MySQL esté completamente listo.

**`image: mysql:8.0.21 `**: agrega la dependencia de tu mysql que estabas utilizando en tu proyecto local, chequea que version estabas usando en tu maquina.

**`ports:"3307:3306"`**: mapea el puerto 3306 dentro del contenedor MySQL al puerto 3307 en tu máquina host, para evitar un conflicto si ya tienes corriendo el 3306 en tu maquina.

**`MYSQL_ROOT_PASSWORD`**: Esta línea establece la contraseña para el usuario con todos los privilegios de MySQL.

**`MYSQL_PASSWORD`**: Esta línea establece la contraseña para un usuario anónimo.

**`MYSQL_DATABASE`**: Esta línea crea una base de datos llamada cursos dentro de MySQL.

**`test: ["CMD", "mysqladmin" ,"ping", "-h", "localhost"]`**: Este comando intenta hacer un ping al servidor MySQL usando mysqladmin.

**` timeout: 10s | retries: 10`**: Si se cae un servicio de la DB tiene 10 intentos de recuperar la conectividad y cada intento dura 10 segundos para lograrlo, sino el servicio cae completamente.

---

### Paso 8 : Ejecutar y construir nuestro docker-compose para crear una Imagen en Docker 🏃‍♂️

1. Encendemos el Docker Desktop haciendo click en nuestro icono de escritorio.

2. Nos posicionaremos nuevamente en la carpeta donde se encuentra nuestro *`docker-compose`* y abriremos una nueva línea de comandos (consola/terminal).

3. Una vez allí ejecutaremos el comando *`docker-compose build`*  y comenzaras a visualizar unos comandos azules como estos.

![compose](https://miro.medium.com/v2/resize:fit:1400/1*T1Ip2R105svnn4410AHIww.png)

---
### Paso 9 : Ejecutar y construir nuestro contenedor de App en Docker 🏃‍♂️

1. Nos posicionaremos nuevamente en la carpeta donde se encuentra nuestro *`docker-compose`* y abriremos una nueva línea de comandos (consola/terminal).

2. Una vez allí ejecutaremos el comando *`docker-compose up`*  y comenzaras a visualizar unos comandos azules como estos.

![Compilar App](https://www.sohamkamani.com/java/spring-rest-http-server/server-startup-terminal.png)

3. Cuando veas el logo de Spring ya puedes ir a tu http://localhost:8080/doc y probar tu API.



¡Felicidades! 🎉 Has desplegado tu aplicación Spring Boot usando Docker. 🐳🔥
