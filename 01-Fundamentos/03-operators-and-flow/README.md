# Operadores y Control de Flujo

## Operadores Fundamentales

- Aritméticos: ```+ , - , * , / (división), % (residuo)```
- Relacionales (devuelven boolean): ```== , != , > , < , >= , <=```
- Lógicos (Cortocircuito) :
  - ```&&``` (AND) : Si la primera condición es ```false``` no evalúa la segunda porque el resultado ya es imposible que sea ```true```
  - ```||``` (OR) : Si la primera condición es true, no evalua la segunda
  - ```!"``` (NOT) : Invierte el valor lógico ```!false = true```
- Operador Ternario (```? :```) :  Es un ```if - else``` compacto que devuelve el valor en una línea

```java
String estado = (stock > 0) ? "Disponible" : "Agotado";
```

## Condicionales

### IF - ELSE

Estructura ```if - else if - else```

Evalúa condiciones booleanas secuencialmente de arriba hacia abajo. En cuanto una condición resulta true, ejecuta su bloque y omite todo el resto.

```java
int codigoError = 404;

if (codigoError == 200) {
        System.out.println("Petición exitosa");
} else if (codigoError >= 400 && codigoError < 500) {
        System.out.println("Error del cliente");
} else {
        System.out.println("Error del servidor");
}
```
### SWITCH Tradicional vs Expresiones SWITCH modernas

El switch evalúa una variable (enteros, String, char, enum) contra múltiples valores exactos.

- A. El switch tradicional (Instrucción) : Tiene un comportamiento llamado fall-through (caída en cascada): si olvidas poner break; al final de un case, Java seguirá ejecutando los casos de abajo aunque no coincidan.
```java
String dia = "LUNES";
String tipoDia;

switch (dia) {
    case "LUNES":
    case "MARTES":
    case "MIERCOLES":
    case "JUEVES":
    case "VIERNES":
        tipoDia = "Laboral";
        break; // Obligatorio para no caer en 'default'
    case "SABADO":
    case "DOMINGO":
        tipoDia = "Fin de semana";
        break;
    default:
        tipoDia = "Inválido";
        break;
}
```
- B. Expresiones switch modernas (Java 17+) : Resuelven los problemas del switch clásico: eliminan el fall-through usando flechas (->), permiten agrupar casos separados por comas y pueden devolver directamente un valor para asignarlo a una variable.
```java
String dia = "SABADO";

// El switch completo es una expresión que retorna un String
String tipoDia = switch (dia) {
    case "LUNES", "MARTES", "MIERCOLES", "JUEVES", "VIERNES" -> "Laboral";
    case "SABADO", "DOMINGO" -> "Fin de semana";
    default -> {
        // Si un caso requiere varias líneas de lógica, se usan llaves {} y 'yield'
        System.out.println("Día no reconocido: " + dia);
        yield "Inválido"; // 'yield' devuelve el valor del bloque
    }
}; // Lleva punto y coma porque toda la estructura es una asignación
```

### Bucles (Estructuras Repetitivas)

- Bucle for (Clásico / Por índice) : Ideal cuando sabes exactamente cuántas veces quieres repetir algo o necesitas controlar el índice (i).
```java
// (inicialización; condición de permanencia; actualización)
for (int i = 0; i < 5; i++) {
    System.out.println("Iteración número: " + i);
}
```

- Bucle for-each (Enhanced for) : Diseñado para recorrer colecciones o arreglos completos de principio a fin de forma limpia, sin preocuparte por índices ni desbordamientos. No permite modificar la estructura de la colección mientras se recorre.
```java
String[] lenguajes = {"Java", "Python", "SQL"};

for (String lang : lenguajes) {
    System.out.println("Lenguaje: " + lang);
}
```
- Bucle while (Pre-condición) : Evalúa la condición antes de entrar. Si la condición es false desde el inicio, el bloque no se ejecuta ni una sola vez. Se usa cuando no sabes cuántas iteraciones tomará alcanzar un estado.
```java
int intentos = 0;
while (intentos < 3) {
    System.out.println("Conectando...");
    intentos++;
}
```
- Bucle do-while (Post-condición) : Ejecuta el bloque primero y evalúa la condición al final. Garantiza que el código dentro del bucle se ejecute al menos una vez (muy común en menús interactivos o validaciones de entrada).
```java
int opcion;
do {
    System.out.println("Mostrando menú...");
    opcion = 0; // Supongamos que el usuario elige 0 para salir
} while (opcion != 0); // Lleva punto y coma al final
```
- Control de Saltos (break y continue) : Permiten alterar abruptamente el flujo normal dentro de un bucle:
  - break: Aborta y sale inmediatamente del bucle más interno en el que se encuentra, pasando a la primera línea después del cierre }.
  - continue: Salta únicamente la iteración actual y fuerza al bucle a pasar directamente a la siguiente vuelta (evaluando de nuevo la condición).
```java
for (int i = 1; i <= 6; i++) {
    if (i == 3) {
        continue; // Se salta el 3 (no lo imprime) y pasa al 4
    }
    if (i == 5) {
        break;    // Rompe el bucle por completo al llegar a 5
    }
    System.out.print(i + " "); // Imprime: 1 2 4
}
```
- Etiquetas (Labels) para bucles anidados : Si tienes un bucle dentro de otro, un break normal solo rompe el bucle interior. Java permite poner una etiqueta antes del bucle exterior para romper ambos de golpe si es necesario:
```java
busquedaExterna:
for (int fila = 0; fila < 3; fila++) {
    for (int col = 0; col < 3; col++) {
        if (fila == 1 && col == 1) {
            break busquedaExterna; // Sale de AMBOS bucles inmediatamente
        }
    }
}
```
