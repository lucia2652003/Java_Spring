### Ejercicio Nº 1: Patrón DTO

Un restaurante necesita una API que proporcione información detallada sobre las calorías de los platos de su menú.

Para esto, almacena en una base de datos lógica los siguientes datos:

- **Platos:** codigo_plato, nombre, precio, lista_Ingredientes
    
- **Ingredientes:** codigo_ingrediente, nombre, cantidad_calorias
    

La API debe recibir el **nombre** de un plato como parámetro y devolver en base a esto:

1. La cantidad total de calorías del plato completo.
    
2. Una lista de ingredientes que componen el plato, junto con la cantidad de calorías de cada uno (la sumatoria de estas calorías deberían de dar la cantidad total de calorías del plato).
    
3. El ingrediente con la mayor cantidad de calorías en el plato.
    

>💡 Utilizar para las responses el patrón DTO

>💡 Como ayuda, el dueño del restaurante nos brindó dos archivos `.json` con datos tanto de los platos con los que cuenta en el menú, como la lista completa de ingredientes con los que trabaja para cada plato.

- Utilizar ambos archivos como base de datos lógica del sistema. Cargar los datos del json a la aplicación y almacenar los datos en collections.
    

[Descargar ingredientes.json](./resources/ingredients.json)

[Descargar dishes.json](./resources/dishes.json)

>💡 Como ayuda para el manejo de archivos pueden utilizar el siguiente código de ejemplo en la capa que corresponda (ejemplo para ingredientes)

```java
private List<IngredientDTO> loadDataBase() {
    File file = null;
    try {
			//aquí colocamos la url de nuestro archivo json que queremos cargar
      file = ResourceUtils.getFile("classpath:ingredients.json");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    ObjectMapper objectMapper = new ObjectMapper();
    TypeReference<List<IngredientDTO>> typeRef = new TypeReference<>() {};
    List<IngredientDTO> ingreDTO= null;
    try {
      ingreDTO= objectMapper.readValue(file, typeRef);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return ingreDTO;
  }

//para utilizar este código debes tener una clase IgredienteDTO creada o con el nombre que tu prefieras
//de igual manera si cargas el archivo de platos, deberás de tener el DTO correspondiente
```

#### **¿Qué hace este código?**

1. **File Initialization:** Declara una variable `file` inicializada como `null`.
    
2. **Cargar el archivo JSON:** Utiliza `ResourceUtils.getFile("classpath:food.json")` para cargar un archivo JSON desde la ruta especificada. En este caso, la ruta es "classpath:food.json", lo que generalmente indica que el archivo JSON está ubicado en el classpath del proyecto.
    
3. **Manejo de Excepciones:** Captura una posible excepción `FileNotFoundException` que puede ocurrir si el archivo no se encuentra en la ruta especificada. En caso de que ocurra esta excepción, imprime la traza de la excepción.
    
4. **ObjectMapper:** Crea un objeto `ObjectMapper`, que es parte de la biblioteca Jackson en Java y se usa para mapear datos entre objetos Java y formatos de datos como JSON.
    
5. **TypeReference:** Define un `TypeReference` para indicar al `ObjectMapper` el tipo de datos que se espera al deserializar el archivo JSON. En este caso, se espera una lista de objetos `IngredientDTO`.
    
6. **Lectura del archivo JSON:** Utiliza el `ObjectMapper` para leer el contenido del archivo JSON y mapearlo a una lista de objetos `IngredientDTO` utilizando el método `readValue()`.
    
7. **Manejo de Excepciones en la lectura:** Captura una posible excepción `IOException` que puede ocurrir durante la lectura o deserialización del archivo JSON. En caso de que ocurra esta excepción, imprime la traza de la excepción.
    
8. **Retorno de datos:** Retorna la lista de objetos `IngredientDTO` que se ha cargado desde el archivo JSON.
