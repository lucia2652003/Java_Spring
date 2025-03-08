# Guía para Configurar SonarQube 🚀

### Paso 1: Descarga e Instalación de SonarQube 📥
1. **Descarga:** Visita la página oficial de SonarQube y descarga la versión Community desde este enlace: [SonarQube Downloads](https://www.sonarsource.com/products/sonarqube/downloads/).
2. **Extracción:** Descomprime el archivo descargado en tu equipo.
3. **Inicio del Servidor:**
   - En Windows:
     - Abre una terminal.
     - Navega a la carpeta `/bin/windows-x86-64` dentro de la carpeta descomprimida.
     - Ejecuta el archivo `StartSonar.bat`.
     - Puede tardar unos 40 segundos
     - Aceptar permisos en windows.
4. **Acceso a SonarQube:** Abre un navegador y accede a [http://localhost:9000/](http://localhost:9000/).
   - Puede tardar unos 2 min en conectarse a los servidores
5. **Credenciales Iniciales:**
   - Usuario: `admin`
   - Contraseña: `admin`
   - Cambia la contraseña cuando se te solicite. 🔒

---

### Paso 2: Crear un Proyecto en SonarQube 📂
1. **Acceso:** Inicia sesión en SonarQube desde [http://localhost:9000/](http://localhost:9000/).
2. **Crear Proyecto:**
   - Haz clic en "Create a local project".
   - Asigna un nombre al proyecto (por ejemplo: `MiProyecto`).
   - Seleccionar Configuraciones Globales `Use the global setting`
   - Crear proyecto `Create`
   - Click en Localmente `Locally`
3. **Generar un Token:**
   - Vamos a dejar el nombre por defecto y los 30 dias.
   - Haz clic en "Generate Token".
   - Copia el token generado y guárdalo en un archivo de texto. ¡Es importante! 📝
   - **Recomendaciones:** crea un archivo `Token.txt` y guarda el token aqui justo por fuera de tu proyecto para que no se suba a git hub.

---

### Paso 3: Integrar SonarQube con tu Proyecto Local 🛠️
1. **Seleccionar Herramienta de Construcción:**
   - En el menú de configuración, elige tu gestor de dependencias (por ejemplo, Maven).
2. **Configurar Comando:**
   - Copia el comando generado por SonarQube. Puedes gaurdarlo en en mismo archivo `Token.txt`
   - Ajusta el comando según las necesidades de tu proyecto.
   - Te recomendamos un proyecto que ya tengas hecho en spring boot, como el de Swagger o el de de Spring Security
     ```
     mvn clean verify sonar:sonar \
       -Dsonar.projectKey=MiProyecto \
       -Dsonar.host.url=http://localhost:9000 \
       -Dsonar.token=<tu_token>
     ```
   - Nota: Si usas un sistema basado en Windows, elimina las barras invertidas (`\`) del comando. 🖥️
   - Guarda el archivo `Token.txt` con los cambios realizados.
3. **Ejecución:**
   - Vamos a copiar el código de Maven que nos dios Sonar Qube de nuesto `Token.txt`.
   - Luego abrir el proyecto de “Swagger o Spring Security” de forma local utilizando Intellij IDEA como IDE
   - Vamos al apartado Maven (arriba a la derecha de nuestro proyecto)
   - Vamos a seleccionar la opción “Execute Maven Goal”
   - Pega el comando en el terminal del IDE sin las barras /.

---

### Paso 4: Analizar Resultados 📊
1. **Ver Resultados:**
   - Regresa a [http://localhost:9000/](http://localhost:9000/) y selecciona tu proyecto.
   - Revisa métricas como:
     - Código duplicado.
     - Vulnerabilidades de seguridad.
     - Cobertura de pruebas unitarias.
2. **Mejoras:**
   - Aplica las sugerencias para mejorar la calidad del código.

---