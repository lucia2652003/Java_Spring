# 🚀 Integración de Swagger UI en una Aplicación Spring Boot

Este tutorial paso a paso te guiará para agregar Swagger UI a tu aplicación Spring Boot y personalizar la ruta para que puedas acceder a la documentación en `http://localhost:8080/doc`. ¡Manos a la obra! 🛠️

---

## 1. 📦 Agregar las dependencias necesarias

En tu archivo `pom.xml`, añade las siguientes dependencias para integrar Swagger:

```xml
<dependencies>
    <!-- Dependencia para Swagger -->
    <dependency>
			<groupId>org.springdoc</groupId>
			<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
			<version>2.3.0</version>
		</dependency>
</dependencies>
```

Luego, asegúrate de sincronizar tu proyecto para descargar las dependencias con el icono de recargar el maven.

---

## 2. 🏗️ Configurar Swagger en tu EntryPoint

Crea un metodo de configuración para Swagger en el EntryPoint del proyecto, es decir donde esta la anotacion principal que enciende tu app de spring boot:

Agregale un titulo, versiones y una pequeña descripción.

```java
@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().info(new Info()
				.title("Titulo principal de mi API")
				.version("1.1.2")
				.description("Una descripcion corta de cómo esta documentada mi API"));
	}
}

```

---

## 3. ✏️ Personalizar la ruta de Swagger UI

Por defecto, Swagger UI está disponible en `http://localhost:8080/swagger-ui/`. Para cambiar esta ruta a `/doc`, edita el archivo `application.properties`  de tu proyecto.

### Usando `application.properties`

```properties

# habilitar o no api-docs y swagger-ui
springdoc.api-docs.enabled = true
springdoc.swagger-ui.enabled = true

# url o ruta de swagger-ui
springdoc.swagger-ui.path=/doc

```
---

## 4. 🧪 Probar la configuración

1. Inicia tu aplicación Spring Boot normalmente.

2. Abre tu navegador y visita `http://localhost:8080/doc`.

¡Listo! Ahora puedes visualizar tus endpoints de forma interactiva. 🎉

---


## 5. 🛡️ Preguntas frecuentes

### ❓ ¿Qué pasa si no carga Swagger UI?
1. Revisa que las dependencias estén correctamente incluidas.
2. Asegúrate de que tu aplicación Spring Boot esté funcionando sin errores.
3. Verifica que la ruta configurada en `application.properties` o `application.yml` sea la correcta.

---

¡Eso es todo! Ahora tienes una interfaz visual para explorar y probar tus endpoints. 🧑‍💻✨
