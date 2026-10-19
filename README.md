# Práctica: Arquitectura Modular - Colas (Estática Lineal, Circular y Dinámica)

**Instituto Tecnológico Superior de Xalapa (ITSX)**  
**División de Ingeniería en Sistemas Computacionales**  
**Asignatura:** Estructura de Datos (Clave: AED-1026)  
**Docente:** Mtro. Víctor Hugo Vásquez Herrera  
**Alumno:** Gerardo González Ramírez  
**Fecha:** 18 Octubre de 2026  

---

##  Descripción del Proyecto

El presente proyecto implementa y evalúa de manera comparativa el Tipo de Dato Abstracto (TDA) **Cola** en el lenguaje de programación Java bajo la disciplina estricta **FIFO** (*First In, First Out* / Primero en entrar, primero en salir).

Se implementan y contrastan tres variantes arquitectónicas:
1. **Cola Estática Lineal:** Basada en arreglos contiguos de tamaño predeterminado con desplazamiento unidireccional de índices.
2. **Cola Estática Circular:** Basada en arreglos que optimizan y reciclan el espacio liberado al frente mediante operadores de aritmética modular (`% capacidad`).
3. **Cola Dinámica Enlazada:** Basada en nodos autorreferenciados instanciados en memoria dinámica (*Heap*), ofreciendo elasticidad total y delegando la desasignación de memoria al *Garbage Collector* de la JVM.

---

##  Estructura y Modularidad del Proyecto

El proyecto sigue una arquitectura modular limpia, desacoplando los modelos de datos de las clases ejecutoras:

```text
src/
└── estructuras_lineales/
    ├── Nodo.java                  # Unidad fundamental de enlace dinámico
    └── colas/
        ├── ColaEstatica.java          # Implementación estática contigua
        ├── ColaEstaticaCircular.java  # Implementación circular con módulo
        ├── colaDinamica.java          # Implementación enlazada con nodos
        ├── MainColaEstatica.java      # Ejecutable independiente: Cola Lineal
        ├── MainColaCircular.java      # Ejecutable independiente: Cola Circular
        └── MainColaDinamica.java      # Ejecutable independiente: Cola Dinámica

Métodos y Especificación Técnica1. ColaEstatica.javaenqueue(int valor): Inserta un elemento al final de la cola validando límites físicos (fin == capacidad - 1).dequeue(): Extrae y retorna el elemento al frente incrementando el puntero frente.peek(): Consulta e inspecciona el valor al frente sin extraerlo ni alterar apuntadores.mostrar(): Recorre e imprime la fila actual desde frente hasta fin.2. ColaEstaticaCircular.javaenqueue(int valor): Inserta calculando el siguiente índice mediante (fin + 1) % capacidad y controlando el atributo tamano.dequeue(): Extrae el elemento frontal avanzando con (frente + 1) % capacidad y decrementando tamano.peek(): Retorna el elemento en la posición frente sin modificar apuntadores ni contadores.mostrar(): Muestra los elementos activos en orden lógico respetando la rotación del arreglo.3. colaDinamica.javaencolar(int x): Instancia un nuevo Nodo en el Heap y actualiza el apuntador fin.desencolar(): Retira el nodo frontal (frente = frente.siguiente), dejando el nodo previo disponible para el Garbage Collector.peek(): Retorna el campo dato del nodo frente sin desvincularlo.contarElementos(): Recorre la lista enlazada desde frente hasta null para calcular el número total de nodos activos en tiempo de ejecución.mostrar(): Despliega la cadena completa de nodos desde el frente hasta el fin.🚀 Compilación y EjecuciónPara compilar y ejecutar de forma independiente cada módulo desde la terminal:Bash# Compilar todo el proyecto
javac estructuras_lineales/Nodo.java estructuras_lineales/colas/*.java

=== PRUEBA: COLA ESTÁTICA LINEAL ===
Encolado: 10
Encolado: 20
Encolado: 30
Error: La cola está llena.
Frente -> [10] [20] [30] <- Fin
Elemento al frente (peek): 10
Atendido y fuera: 10
Frente -> [20] [30] <- Fin

=== PRUEBA: COLA ESTÁTICA CIRCULAR ===
Encolado circular: 10
Encolado circular: 20
Encolado circular: 30
Frente -> [10] [20] [30] <- Fin
Elemento al frente (peek): 10
Atendido y fuera: 10
Frente -> [20] [30] <- Fin
Encolado circular: 40
Frente -> [20] [30] [40] <- Fin

=== PRUEBA: COLA ESTÁTICA CIRCULAR ===
Encolado circular: 10
Encolado circular: 20
Encolado circular: 30
Frente -> [10] [20] [30] <- Fin
Elemento al frente (peek): 10
Atendido y fuera: 10
Frente -> [20] [30] <- Fin
Encolado circular: 40
Frente -> [20] [30] [40] <- Fin