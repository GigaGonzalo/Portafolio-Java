# Anatomía de un Programa en JAVA

## Packages

Son aquellos entornos de trabajo o workspace donde residen las clases, enumeradores e interfaces. Agrupando los archivos necesarios

### Caracteristicas

- Siempre se escriben en la línea primera del archivo .java

- Su convensión de nombres es la inversa a internet.

    Ejemplo: ```com.empresa.facturacion```

- El nombre del paquete dicta la jerarquia exacta del directorio donde reside

    Ejemplo: ```.../com/empresa/facturacion```

- Si no se escribe el nombre del package este por defecto reside en el **paquete sin nombre**
---
## Imports

Se escribe despúes de package y srive para importar o traer clases de packages externos, para utilizar sus metodos, variables, etc.

### Caracteristicas

- Importaciones específicas: Llama una clase concreta de un package externo.

    Ejemplo: ```import java.util.Scanner;```

- Importaciones con comodin: Llama a todas las clases publícas de un package.

    Ejemplo: ```import java.util.*;```

- Importaciones Estaticas (**_static_**): Al momento de importar, si se agrega static a una constante o metodo, este se puede utilizar sin anteponer el nombe de la clase importada.

    Ejemplo: ```import static java.lang.Math.PI;``` para usar ```PI``` y no ```Math.PI```

- Importaciones Implícitas: JAVA importa todas las clases ```java.lang.*``` y todas las clases dentro del mismo package

- Colisiones de Nombres: Si se utilizaran metodos con el mismo nombre, pero de diferente package, uno tendra que ser importando y el otro tendra que ser referenciado a traves de su Fully Qualified Name (**_java.util....;_**) o ambos usan la referencia cualificada


    Ejemplo: ```import java.util.Date``` y ```java.sql.Date fechaSql = .....```
---
## Metodo MAIN

Es el metodo principal de ejecución de cualquier programa de JAVA y se escribe como:

    public static void main(String[] args)

### Caracteristicas

- Es **public** para ser visible para la _JVM_ o cualquier otro llamador externo
- Es **static** para poder ser llamado sin la necesidad de crear un objeto que lo instancie ya qué el programa aún no ha iniciado.
- Es **void** ya que no regresa valores al final de la ejecución del programa. A menos que se especifique en ```System.exit(int)```
- Es **main** ya que es el nombre que buscara la JVM ( **_Java Virtual Machine_** ) para ejecutar el programa
- **String[] args** para recibir argumentos de línea de comandos al ejecutarse.

---
## Organizacion del archivo .JAVA

Es el archivo que contiene una o varias clases, variables, metodos y la logica subyacente.

### Caracteristicas

- Un archivo .java puede contener multiples clases, enumeradores e interfaces, pero solo una puede ser **public**
- Si existe una clase **public** esta debe contener el mismo nombre del archivo .JAVA
- Las clases que no son publícas dentro del mismo archivo, tambíen llamadas ```package-private```, tienen visibilidad en el package al que pertenece y el compilador genera su propio .class
- La estructura estandar para proyectos profesionales usando herramientas como Maven o Gradle es separar el código fuente de los binarios.

```text
mi-proyecto/
├── src/                  <-- Código fuente (.java)
│   └── com/
│       └── empresa/
│           └── app/
│               ├── Main.java
│               └── Usuario.java
└── out/ (o target/)      <-- Bytecode compilado (.class)
    └── com/
        └── empresa/
            └── app/
                ├── Main.class
                └── Usuario.class
```
---
## Compilación (_javac_) vs Ejecición (_java_)

Java es un lenguaje híbrido compila e interpreta en tiempo real, gracias al principio _"Write Once, Run Anywhere"_ o _WORA_. Ambos se ejecutan en dos fases:

- Fase Uno: El compilador verifíca la sintaxis, resuleve importaciones, comprueba tipos estaticos y genera el archivo .class traduciendo el codigo fuente (.java) a bytecode (.class), un bloque de instrucciones intermedio y universal para la JVM. Utiliza la estructura ```com/empresa/archivo.java ```
- Fase Dos: El ejecutor arranca la JVM, carga los archivos _.class_ en memoria a traves de ClassLoader, verifica la seguridad del bytecode,  busca el método **main**, traduce el bytecode al lenguaje del Sistema Operativo nativo donde se ejecuta a traves del compilador _JIT_ (**_Just-In-Time_**). Utiliza la estructura ```com.empresa.archivo```
