# Portafolio de Aprendizaje Autodidacta del Lenguaje de Programación JAVA 

Fundamentos de programacion JAVA

Temario de los fundamentos para aprender el lenguaje JAVA

Estara dividido en fases y cada fase implementara dos proyectos a partir de la segunda fase.

- El primero implementara lo aprendido exclusivamente en los temas de la fase correspondiente

- El segundo implementara lo aprendido en incluyendo las fases anteriores

## FASE 1 : Fundamentos del lenguaje y flujo de ejecución 

### Anatomía de un programa JAVA 
- Paquetes (Package)
- Importaciones (import)
- Método _main_ 
- Compilación (_javac_) vs Ejecución (_javac_)
- Organizacion de archivos (_.java_)

### Sistemas de tipos y memoria básica
- Tipos primitivos (_int,double, boolean, char, etc._) frente a tipos de referencia
- Conversión explícita/implícita (_casting_)
- Diferencias entre memoria Stacky Heap a nivel conceptual

### Operadores y Controles de flujo

- Condicionales (_if-else, switch tradicional y expresiones switch modernas_)
- Bucles (_for, for-each, while, do-while_) y controles de salto (_break, continue_)

### Entrda/Salida y Manipulación básica

- Uso de _Scanner_ para leer datos de consola
- Formateo de salida y manejo fundamental de cadenas (_string, inmutabilidad, StringBuilder_)

### Arreglos

- Declaración
- Recorridos
- Arreglos bidimensionales
- Limitaciones del tamaño fijo

## FASE 2 : Programación Orientada a Objetos (_POO_)

### Clases y Objetos

- Atríbutos
- Métodos
- Constructores
- Sobrecarga (_Overloading_)
- Palabra clave _this_
- Ciclo de vide de un Objeto

### Encapsulamiento y Modificadores

- _private_
- _public_
- _protected_
- Acceso por paquete
- _static_ (miembros de clases vs instancias)
- _final_ (constantes, métodos y clases)

### Herencia y Polimorfismo

- _extends_
- _super_
- Sobreescritura de métodos (_@Override_)
- Enlace dinámico
- Uso de _Object_ (_toString, equals, hashCode_)

### Abstracción y Contratos

- Clases abstractas (_abstract_)
- Interfaces (_interface_)
- Métodos _default_ y _static_ en interfaces
- Cuando preferir Composicióm sobre Herencia

### Caracteristicas Modernas de Modelado

- Enumeraciones (_Enum_ con atributos y métodos)
- _records_ para objetos inmutables de datos
- Clases selladas (_sealed_)

## FASE 3 : Estructura de Datos, Genéricos y Manejo de Errores

### Manejo de Excepciones

- Jerarquía de _Throwable_ 
- _Exception_ vs _RuntimeException_ (checked vs unchecked)
- Bloques _try-catch-finally_
- _try-with-resources_
- Creacción de Excepciones Personalizadas

### Genéricos (_Generics_)

- Clases
- Interfaces
- Métodos Genéricos (_< T >_)
- Seguridad de tipos en tiempo de compilación 
- Comodines (wildcards: _? extends_, _? super_)

### Java Collections Framework

- Listas (_ArrayList, LinkedList_)
- Conjuntos (_HashSet, LinkedHashSet, TreeSet_ y el contrato _equals/hashCode_)
- Mapas (_HashMap, LinkedHashMap, TreeMap_)
- Colas y Pilas (_ArrayDeque, PrioriyQueue_)
- Ordenamiento (_Comparable vs Comparator_)

## FASE 4 : Programación Fundamental y APIs Modernas

### Expresiones Lambda e Interfaces Funcionales

- _Predicate_
- _Function_
- _Consumer_
- _Supplier_
- Referencia de métodos ( _::_ )

### Stream API

- Operaciones intermedias (_filter, map, flatMap, sorted, district_)
- Terminales (_collect, reduce, forEach, findFirst, anyMatch_)

### Manejo Seguro de Ausencias

- Uso correcto de _Optional_ para evitar _NullPointerException_

### API Moderna de Fechas y Tiempo (_java.time_)

- _LocalDate_
- _LocalTime_
- _LocalDateTime_
- _ZonedDateTime_
- _Duration_
- _Period_

## FASE 5 : Persistencia, Herramientas Profesionales y Concurrencia

### Entrada/Salida y Archivos (_java.nio.file_)

- Lectura y escritura con _Path_ y _Files_
- Serializacion Básica (por ejemplo, JSON con librerias externas)

### Gestión de Proyectos y Dependencias

-Transicion de compilación manual a Maven o Gradle (estructura estandar _src/main/java_ y _src/test/java_)

### Pruebas Unitarias

- Introducción a JUnit 5 (aserciones, ciclos de vida de pruebas, casos borde) para verificar tus clases sin depender de imprimir en consola

### Concurrencia Básica

- Hilos (_Thread, Runnable_)
- Condiciones de Carrera
- _ExecutorService_
- _CompletableFuture_
- Nociones de Sincronización

### Conexión a Base de Datos (_JDBC_)

- Conexión desde Java a base de datos relacional (_PostgreSQL o MySQL/SQLite_)
- Consultas parametrizadas ( _PreparatedStatement_ )
- Patrón _DAO/Repository_





## Instalación