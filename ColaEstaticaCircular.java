package estructuras_lineales.colas;

public class ColaEstaticaCircular {
    private int[] arreglo;
    private int capacidad;
    private int frente;
    private int fin;

    // =========================================================
    // Control exacto de elementos para evitar colapso de índices
    // =========================================================
    private int tamano;

    // Constructor
    public ColaEstaticaCircular(int capacidad) {
        this.capacidad = capacidad;
        this.arreglo = new int[capacidad];
        this.frente = 0;
        this.fin = -1;
        this.tamano = 0;
    }

    // Método para insertar (enqueue)
    public void enqueue(int valor) {
        if (tamano == capacidad) {
            System.out.println("Error: La cola está llena.");
            return;
        }

        // Avance circular con módulo
        fin = (fin + 1) % capacidad;
        arreglo[fin] = valor;
        tamano++;
        System.out.println("Encolado circular: " + valor);
    }

    // Método para atender (dequeue)
    public int dequeue() {
        if (tamano == 0) {
            System.out.println("Error: La cola está vacía.");
            return -1;
        }

        int atendido = arreglo[frente];
        frente = (frente + 1) % capacidad;
        tamano--;

        System.out.println("Atendido y fuera: " + atendido);
        return atendido;
    }

    // =========================================================
    // MÉTODO SOLICITADO: peek()
    // Consulta el elemento al frente sin extraerlo ni alterar apuntadores[cite: 14]
    // =========================================================
    public int peek() {
        if (tamano == 0) {
            System.out.println("Error: La cola está vacía.");
            return -1; //[cite: 14]
        }
        return arreglo[frente]; //[cite: 14]
    }

    // Método para mostrar los elementos
    public void mostrar() {
        if (tamano == 0) {
            System.out.println("Cola vacía.");
            return;
        }

        System.out.print("Frente -> ");
        for (int i = 0; i < tamano; i++) {
            int indice = (frente + i) % capacidad;
            System.out.print("[" + arreglo[indice] + "] ");
        }
        System.out.println("<- Fin");
    }
}