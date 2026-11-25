# Sistemas de Tipos y Memoria Básica

## Sistema de Tipos
JAVA separa los tipos en dos grandes categorias:

- Tipos primitivos
  - _byte_ ------> 1 byte (8 bits) ---> 	-128 a 127
  - _short_  ------> 2 bytes (16 bits) ------> 	-32,768 a 32,767
  - _int_  ------> 4 bytes (32 bits)$\approx  ------> -2,147$ millones a $+2,147$ millones (Estándar)
  - _long_ ------>  8 bytes (64 bits)	 ------> Números enteros gigantes (lleva sufijo L)
  - _float_  ------> 4 bytes (32 bits)	 ------> Precisión simple, ~6-7 decimales (sufijo f)
  - _double_ ------>  8 bytes (64 bits)	 ------> Precisión doble, ~15 decimales (Estándar)
  - _char_ ------>  2 bytes (16 bits)	 ------> Un solo carácter Unicode (usa comillas simples ' ')
  - _boolean_ ------>  ~1 bit (depende JVM)	 ------> Solo true o false (no acepta 1 ni 0)
```text
Nota: Todos los primitivos comienzan con minusculas y poseen 
valores iniciales que permanecen si no se asigna otro valor 
int a ----->  a = 0
Nunca pueden valer null.
```
- Tipos de Referencia (_Objetos_): Son todos aquellos que no son primitivos, como _String, Scanner, int [ ], clases propias, listas(ArrayList),etc_.
  - Por estandar comienzan con mayúsculas
  - Poseen atributos y métodos propios
  - Su valor por defecto es ```null``` que significa que no apunta a ningun objeto en memoria todavía
  - La diferencia es que los primitivos almacenan un valor real, mientras que una variable de referencia almacena una dirección en memoria

## Memoria Stack vs Heap 

Cuando ejecutas un programa, la JVM divide la memoria en dos grandes zonas principales: Stack (_pila_) y Heap (_montón_)

- Memoria Stack (_Pila_)
  - Almacena variables locales de los métodos, valores reales de los primitivos y las referencias hacia objetos.
  - Es muy rapido y de tamaño limitado. Cada vez que termina un metodo, sus variables en el Stack se eliminan automáticamente
- Memoria Heap (_Mónton_)
  - Guarda todos los objetos reales creados en el programa (cada vez que usas ```new``` o ```String```)
  - Es un espacio en memoria mucha más grande y flexible compartida por toda la aplicación. Los objetos siguen existiendo incluso si el metodo que los creo ya terminó, hasta que ya nadie los referiencie. En ese momento entra el Garbage Colector (_Recolector de Basura_) de JAVA para limpiar los objetos huérfanos y liberar espacio.
### Consecuencias prácticas al copiar variables

Con primitivos ```(int a = 10; int b = a;)```: Se copia el valor en el Stack. Si luego cambias b = 20, a sigue valiendo 10. Son independientes.

Con referencias ```(Persona p1 = new Persona("Ana"); Persona p2 = p1;)```: Solo se copia la dirección de memoria en el Stack, pero ambas apuntan al mismo objeto en el Heap. Si modificas el nombre usando p2, el cambio también se verá reflejado al consultar p1.

## Conversion de Tipos (_Casting_)

El casting consiste en convertir un tipo de dato en otro

- Conversión Implícita: Ocurre automáticamente cuando pasas de un tipo más pequeño a uno más grande. No requiere sintaxis especial.
```
Jerarquia: byte --> short --> int --> long --> float --> double
```
Ejemplo :
```java
int entero = 100;
double decimal = entero; // Java lo convierte automáticamente a 100.0
```
- Conversión Explícita: Cuando intentas convertir un tipo más grande a uno más pequeño, existe riesgo de perdida de información o decimales, el compilador (_javac_) bloquea la operación a menos que tú asumas la responsabilidad escribiendo el tipo destino entre paréntesis

Ejemplo con perdida de decimales
```java
double precioExacto = 49.99;
// int precioEntero = precioExacto;  <-- ERROR de compilación: posible pérdida de datos
int precioEntero = (int) precioExacto; // Explícito: trunca (corta) los decimales -> vale 49
```
Ejemplo con desbordamiento (_Overflow_)
```java
int numeroGrande = 130;
byte numeroPequeno = (byte) numeroGrande; // Como byte solo llega a 127, da la vuelta -> vale -126

Nota: También existe el casting entre tipos de referencia cuando hay herencia entre clases, 
por ejemplo convertir un tipo general Animal a uno específico Perro usando (Perro) miAnimal
```
