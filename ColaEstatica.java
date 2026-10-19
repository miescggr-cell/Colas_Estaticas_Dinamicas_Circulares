package estructuras_lineales.colas;;

public class ColaEstatica {
    private int[] arreglo;
    private int frente;
    private int fin;
    private int capacidad;

    // Constructor que recibe la capacidad
    public ColaEstatica(int tamano) {
        this.capacidad = tamano;
        this.arreglo = new int[this.capacidad];
        this.frente = 0;
        this.fin = -1;
    }

    // Insertar elemento al final
    public void enqueue(int valor) {
        if (fin == capacidad - 1) {
            System.out.println("Error: La cola está llena.");
            return;
        }
        fin++;
        arreglo[fin] = valor;
        System.out.println("Encolado: " + valor);
    }

    // Extraer elemento del frente
    public int dequeue() {
        if (frente > fin) {
            System.out.println("Error: La cola está vacía.");
            return -1;
        }
        int atendido = arreglo[frente];
        frente++;
        System.out.println("Atendido y fuera: " + atendido);
        return atendido;
    }

    // Consultar el frente sin extraerlo (Requisito de la práctica)
    public int peek() {
        if (frente > fin) {
            System.out.println("Error: La cola está vacía.");
            return -1;
        }
        return arreglo[frente];
    }

    // Mostrar el contenido actual
    public void mostrar() {
        if (frente > fin) {
            System.out.println("La cola está vacía.");
            return;
        }

        System.out.print("Frente -> ");
        for (int i = frente; i <= fin; i++) {
            System.out.print("[" + arreglo[i] + "] ");
        }
        System.out.println("<- Fin");
    }
}