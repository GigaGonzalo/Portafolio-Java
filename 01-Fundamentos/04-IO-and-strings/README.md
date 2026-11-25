# Entrada/Salidas y Manipulación Básica

## Lectura de Datos en Consola (```Scanner```)

La clase ```java.util.Scanner``` (requiere ```import java.util.Scanner;```) actúa como un traductor que envuelve el flujo estándar de entrada del teclado (System.in) y convierte los caracteres que escribes en tipos de datos de Java (int, double, String, etc.).

```java
import java.util.Scanner;

public class LecturaConsola {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Ingresa tu edad: ");
        int edad = lector.nextInt(); // Lee solo el número entero

        // ¡TRAMPA CLÁSICA DE JAVA! Limpieza de buffer:
        lector.nextLine(); 

        System.out.print("Ingresa tu nombre completo: ");
        String nombre = lector.nextLine(); // Lee toda la línea hasta el Enter

        System.out.println("Hola " + nombre + ", tienes " + edad + " años.");
        
        lector.close(); // Buena práctica: cerrar el recurso al terminar
    }
}
```
- Métodos principales de ```Scanner```
  - ```nextInt()```, ```nextDouble()```, ```nextBoolean()```: Leen el siguiente token (dato separado por espacios o saltos de línea) y lo convierten al primitivo correspondiente. Si el usuario escribe texto cuando se espera un número, lanzan ```InputMismatchException```.

  - ```next()```: Lee una sola palabra (se detiene en cuanto encuentra un espacio en blanco).

  - ```nextLine()```: Lee toda la línea completa (incluyendo espacios) hasta encontrar un salto de línea (\n).

- El problema del salto de línea residual (Buffer trap)

Cuando escribes 31 y presionas Enter, envías al flujo ```31\n```. El método ```nextInt()``` toma únicamente el ```31``` y deja el ```\n``` (el Enter) flotando en el buffer. Si inmediatamente después llamas a ```nextLine()```, este verá ese ```\n``` pendiente, creerá que ya presionaste Enter con un texto vacío y se saltará la captura. Por eso se intercala un ```lector.nextLine();``` vacío para consumir ese Enter antes de leer texto.

## Formateo de Salida (```println```, ```print```, ```printf```)

La clase ```System.out``` ofrece tres formas principales de mostrar datos en consola:

- ```System.out.print(...)```: Imprime el texto y deja el cursor en la misma línea.

- ```System.out.println(...)```: Imprime el texto y agrega un salto de línea al final.

- ```System.out.printf(...)``` (Salida formateada): Permite construir plantillas usando especificadores de formato (heredados de C) para alinear columnas, limitar decimales o rellenar con ceros, sin tener que concatenar con +.

### Especificadores más usados en ```printf```

|Especificador|	Tipo de dato|	Ejemplo de formato|	Resultado|
|-----------------------|---------------------------|----------------------------------------------|---------------|
|```%s```|	String (Texto)|	%-10s (alineado a la izquierda, 10 espacios)|	"Java "|
|```%d```|	Enteros (int, long)	|%04d (rellena con ceros hasta 4 dígitos)|	"0042"|
|```%f```|	Decimales (double, float)|	%.2f (redondea a 2 decimales)|	"19.99"|
|```%b```|	boolean|	%b|	"true"|
|```%n```|	Salto de línea|	Multiplataforma (mejor que \n en printf)|	Nueva línea|

```java
Java

String producto = "Monitor";
int codigo = 7;
double precio = 3450.5678;

System.out.printf("ID: %03d | Producto: %-10s | Total: $%.2f%n", codigo, producto, precio);
// Salida: ID: 007 | Producto: Monitor    | Total: $3450.57
```
## Manejo Fundamental de Cadenas (String e Inmutabilidad)

En Java, String no es un tipo primitivo; es una clase (tipo de referencia). Además, tiene una propiedad arquitectónica fundamental: los objetos String son inmutables.

### ¿Qué significa que ```String``` sea inmutable?

Una vez que se crea un objeto ```String``` en la memoria Heap, su contenido jamás puede modificarse. Cualquier método que parezca alterar un ```String``` (```toUpperCase()```, ```replace()```, ```concat()```, o el operador ```+```) en realidad crea un objeto String completamente nuevo en otra dirección del Heap y deja el original intacto.

```java
String saludo = "Hola";
saludo = saludo + " Mundo"; 
// 1. "Hola" sigue existiendo intacto en el Heap.
// 2. Se crea un nuevo objeto "Hola Mundo" en otro lugar del Heap.
// 3. La referencia 'saludo' en el Stack ahora apunta al nuevo objeto.
```

### El String Pool (Piscina de Cadenas)

Como los textos son inmutables y se repiten mucho en los programas, Java optimiza la memoria reservando una zona especial dentro del Heap llamada String Pool:

    Si escribes String a = "Java"; y luego String b = "Java";, Java detecta que "Java" ya existe en el Pool y hace que ambas variables apunten al mismo objeto para ahorrar RAM.

    Si fuerzas String c = new String("Java");, obligas a crear un objeto duplicado fuera del Pool. Por esta razón, a == c dará false (distinta dirección), mientras que a.equals(c) dará true (mismo contenido).

### Métodos esenciales de ```String```

- ```.length()```: Devuelve la cantidad de caracteres (es un método con paréntesis, a diferencia de los arreglos donde ```.length``` no lleva paréntesis).

- ```.charAt(indice)```: Devuelve el char en esa posición (empezando en 0).

- ```.substring(inicio, fin)```: Extrae una subcadena (inicio inclusivo, fin exclusivo).

- ```.equals(otro)``` / ```.equalsIgnoreCase(otro)```: Compara contenido (sensible o insensible a mayúsculas).

- ```.trim()``` / ```.strip()```: Elimina espacios en blanco al inicio y al final (```strip()``` es más moderno y soporta espacios Unicode).

- ```.contains("texto")```, ```.startsWith("pre")```, ```.endsWith("suf")```: Devuelven boolean.

## ```StringBuilder``` (Cadenas Mutables)

Debido a la inmutabilidad de String, concatenar texto dentro de un bucle (+=) es un antipatrón grave de rendimiento: si haces 10,000 iteraciones, crearás 10,000 objetos String basura en el Heap, saturando al Garbage Collector.

Para construir o modificar texto dinámicamente se usa StringBuilder, que mantiene un arreglo interno mutable de caracteres en el Heap que crece según se necesita sin crear objetos nuevos en cada paso.

```java
// ❌ INEFICIENTE (Crea cientos de objetos String intermedios en memoria):
String reporteLento = "";
for (int i = 1; i <= 100; i++) {
    reporteLento += "Línea " + i + "\n";
}

// ✅ ÓPTIMO (Modifica un único buffer en memoria):
StringBuilder sb = new StringBuilder();
for (int i = 1; i <= 100; i++) {
    sb.append("Línea ").append(i).append("\n"); // Encadenamiento de métodos
}
String reporteFinal = sb.toString(); // Se convierte a String inmutable solo al final
```
### Métodos clave de ```StringBuilder```

- ```.append(dato)```: Agrega texto, números o booleanos al final del buffer.

- ```.insert(indice, dato)```: Inserta texto en una posición específica desplazando el resto.

- ```.delete(inicio, fin)```: Elimina un rango de caracteres.

- ```.reverse()```: Invierte toda la cadena en su lugar.

- ```.toString()```: Exporta el contenido construido a un objeto String estándar.
