# Arreglos

Un arreglo (Array) en Java es una estructura de datos que almacena una secuencia ordenada de elementos del mismo tipo en posiciones contiguas de la memoria Heap. A diferencia de las listas en Python, los arreglos en Java son estructuras de bajo nivel, extremadamente rápidas, pero rígidas en su tipo y longitud.

## Declaración, Instanciación e Inicialización

Aunque un arreglo guarde tipos primitivos (como ```int[]```), el arreglo en sí mismo es un objeto en Java: su referencia vive en el Stack y el bloque con sus casillas vive en el Heap.

Existen dos formas principales de crear un arreglo unidimensional:

### Reservando espacio vacío (cuando aún no tienes los datos): 
Debes indicar obligatoriamente el tamaño exacto con ```new tipo[tamaño]```. Java rellena automáticamente todas las casillas con el valor por defecto del tipo (```0``` para números, ```false``` para boolean, ```null``` para objetos).

```java
int[] codigos = new int[4]; // Crea 4 casillas: [0, 0, 0, 0]

// Asignación manual por índice (siempre empieza en 0)
codigos[0] = 101;
codigos[1] = 102;
codigos[3] = 104; // La casilla [2] conserva el 0 por defecto
```

### Inicialización directa (cuando ya conoces los valores)

Java calcula el tamaño automáticamente contando los elementos entre llaves {}:

```java
String[] turnos = {"Matutino", "Vespertino", "Nocturno"}; // Tamaño fijo: 3
```
## Recorrido de Arreglos

Todo arreglo tiene una propiedad pública e inmutable llamada .length (sin paréntesis, a diferencia de String.length()) que indica cuántas casillas posee.

### Bucle ```for``` tradicional (con índice)

Útil cuando necesitas saber la posición exacta (i), modificar elementos del arreglo o recorrerlo en orden inverso.
Java

```java
double[] precios = {150.0, 299.5, 80.0};

for (int i = 0; i < precios.length; i++) {
    // Aplicamos un 10% de descuento modificando cada casilla directamente
    precios[i] = precios[i] * 0.90;
    System.out.println("Índice " + i + ": $" + precios[i]);
}
```

### Bucle ```for-each``` (solo lectura secuencial)

Más limpio y seguro para leer cada elemento sin riesgo de equivocarse en los límites del índice.

```java
for (double precio : precios) {
    System.out.println("Precio final: $" + precio);
}
```
Si intentas modificar la variable precio dentro de un ```for-each``` (ej. precio = 0;), solo cambias una copia temporal en el Stack, no alteras el arreglo original en el Heap.

## Impresión rápida para depuración (```Arrays.toString```)

Si haces ```System.out.println(precios);``` directamente, Java imprimirá la referencia de memoria (algo como ```[D@1b6d3586```). Para ver el contenido legible, usa la clase utilitaria ```java.util.Arrays```:

```java
import java.util.Arrays;

System.out.println(Arrays.toString(precios)); // Imprime: [135.0, 269.55, 72.0]
```

### Arreglos Bidimensionales (Matrices)

En Java no existen las matrices matemáticas puras como una cuadrícula continua; un arreglo bidimensional (```tipo[][]```) es literalmente un arreglo de arreglos (un arreglo principal en el Heap donde cada casilla guarda la referencia hacia otro arreglo secundario).

```java
// Declaración: [filas][columnas]
int[][] inventario = new int[2][3]; // 2 filas, 3 columnas

// O inicialización directa:
int[][] matriz = {
    {10, 20, 30}, // Fila 0 (longitud 3)
    {40, 50, 60}  // Fila 1 (longitud 3)
};

// Acceso: matriz[fila][columna]
int valor = matriz[1][2]; // Fila 1, Columna 2 -> 60
```
### Recorrido con bucles anidados

```java
for (int fila = 0; fila < matriz.length; fila++) {
    for (int col = 0; col < matriz[fila].length; col++) {
        System.out.print(matriz[fila][col] + "\t");
    }
    System.out.println(); // Salto de línea al terminar cada fila
}
```
Para imprimir una matriz completa en una sola línea de depuración se usa ```Arrays.deepToString(matriz)```

### Arreglos Irregulares (Jagged Arrays)

Como cada fila es un arreglo independiente en el Heap, Java permite que cada fila tenga un tamaño distinto:

```java
int[][] irregular = new int[2][]; // Solo definimos 2 filas
irregular[0] = new int[2];        // La fila 0 tiene 2 columnas
irregular[1] = new int[5];        // La fila 1 tiene 5 columnas
```
## Limitaciones del Tamaño Fijo

- La característica más crítica de los arreglos en Java es que su tamaño es inmutable una vez creados en el Heap.

- No pueden crecer ni encogerse: Si creas ```new String[10]```, siempre tendrá 10 casillas. No existe un método ```.add()``` ni ```.remove()```.

- Error en tiempo de ejecución (```ArrayIndexOutOfBoundsException```): Java verifica estrictamente los límites en cada acceso. Si un arreglo tiene tamaño 3 (índices 0, 1, 2) e intentas acceder a ```arreglo[3]``` o ```arreglo[-1]```, el programa compila bien pero se detiene abruptamente al ejecutarse con esa excepción.

- Desperdicio o falta de espacio: Si reservas 1,000 espacios y solo usas 15, desperdicias 985 casillas en memoria; si llegan 1,001 datos, el arreglo se desborda.

- Costo de redimensionamiento manual: Para "agrandar" un arreglo tradicional, la única vía es crear uno nuevo más grande en el Heap, copiar todos los elementos del viejo al nuevo (por ejemplo con ```Arrays.copyOf(...)```) y reasignar la referencia, dejando el arreglo viejo para que lo limpie el Garbage Collector.


