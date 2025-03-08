# 🗓️ Día 2: Configuración de Spring Data JPA y MySQL en tu aplicación Spring Boot

Este manual te guiará en la integración de **Spring Data JPA** y **MySQL** en tu aplicación, junto con la configuración de una base de datos y pruebas con Postman. ¡Vamos paso a paso! 🚀

---

## 📂 Paso 1: Agregar dependencias en `pom.xml`

Edita el archivo `pom.xml` para incluir las dependencias necesarias para **Spring Data JPA** y el conector de **MySQL**.

### Código
```xml
<dependencies>
    <!-- Dependencia de Spring Data JPA -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

    <!-- Conector de MySQL -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <scope>runtime</scope>
        <version>8.0.21</version>
    </dependency>
</dependencies>
```

### 🔍 Explicación
- `spring-boot-starter-data-jpa`: Proporciona herramientas para trabajar con JPA.
- `mysql-connector-java`: Permite conectar la aplicación a bases de datos MySQL.

---

## 🛠️ Paso 2: Crear la base de datos en MySQL

Abre **SQL Workbench** y ejecuta el siguiente comando para crear una base de datos llamada `prueba_jpa`.

### Código SQL
```sql
CREATE DATABASE prueba_jpa;
```

### 🔍 Explicación
- Este comando crea una base de datos vacía que usará la aplicación para almacenar datos.

---

## ⚙️ Paso 3: Configurar `application.properties`

Edita el archivo `application.properties` para configurar los parámetros de conexión con la base de datos.

### Código
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/prueba_jpa?useSSL=false&serverTimezone=UTC
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Configuración de JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

### 🔍 Explicación
- `spring.datasource.url`: URL para conectarse a la base de datos MySQL.
- ` ?useSSL=false`: Establecen que para esta conexión no se utilizará SSL.
- ` ?serverTimezone=UTC`: Es que tendrá en cuenta una zona horaria estándar para el servidor.
- `spring.datasource.username` y `spring.datasource.password`: Credenciales de tu base de datos.
- `spring.jpa.hibernate.ddl-auto`: `update` crea automáticamente tablas según el modelo.
- `spring.jpa.show-sql`: Muestra las consultas SQL en la consola.

---

## 👤 Paso 4: Crear el modelo `Persona`

En la capa modelo, crea una clase `Persona` con las anotaciones necesarias de **Lombok** y **JPA**.

### Código
```java
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nombre;

    private String apellido;

    private Integer edad;
}
```

### 🔍 Explicación
- `@Entity`: Marca la clase como una entidad JPA.
- `@Id`: Define el atributo `id` como clave primaria.
- `@GeneratedValue`: Genera valores secuenciales automáticamente para `id`.
- Anotaciones de Lombok como `@Data`, `@NoArgsConstructor` y `@AllArgsConstructor` para evitar código repetitivo.

---

## 🗂️ Paso 5: Modificar la capa repositorio

Actualiza la interfaz `PersonaRepositorioInterfaz` para extender de `JpaRepository` borrando los métodos que creamos tanto en la interfaz como en la implementacion.

### Código
```java
public interface PersonaRepositorioInterfaz extends JpaRepository<Persona, Long> {
}
```

### 🔍 Explicación
- `JpaRepository<Persona, Long>`: Proporciona métodos predeterminados como `save`, `findById`, `findAll`, `deleteById`, etc.

---


## 🗂️ Paso 6: Modificar la implementacion PersonaServicio

Actualiza la clase `PersonaServicio`  borrando los llamados de métodos del repositorio que creamos en clases anteriores y remplazalos por los nuevos llamados.

### Código
```java
@Service
public class PersonaServicio implements PersonaServicioInterfaz {

    @Autowired
    PersonaRepositorioInterfaz repository;

    @Override
    public List<PersonaDTO> buscarTodos() {
        List<Persona> personas = repository.findAll();
        return personas.stream()
                .map(PersonaUtil::convertirPersonaAPersonaDTO)
                .collect(Collectors.toList());
    }
}
```

## 🛠️ Paso 8: Probar los endpoints en Postman

### 🌟 Pruebas

#### 1️⃣ **Crear una persona (POST)**
- **Endpoint**: `POST /personas/crear`
- **Cuerpo (JSON)**:
  ```json
  {
    "nombre": "Lionel",
    "apellido": "Messi",
    "edad": 36
  }
  ```

#### 2️⃣ **Obtener todas las personas (GET)**
- **Endpoint**: `GET /personas/traer`

#### 3️⃣ **Eliminar una persona (DELETE)**
- **Endpoint**: `DELETE /personas/borrar/2`

#### 4️⃣ **Actualizar una persona (PUT)**
- **Endpoint**: `PUT /personas/editar/1?nombre=Lionel&apellido=Messi&edad=36`

---

## ✅ ¡Listo!

Ya has configurado tu aplicación para trabajar con Spring Data JPA y MySQL. 🎉 ¡Ahora puedes gestionar datos reales desde tu base de datos! 🚀
