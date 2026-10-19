package estructuras_lineales.colas;

// Reutiliza la clase Nodo que ya tienes en estructuras_lineales
import estructuras_lineales.Nodo;

public class colaDinamica {
    private Nodo frente;
    private Nodo fin;

    public colaDinamica() {
        this.frente = null;
        this.fin = null;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    // Insertar elemento al final de la cola
    public void encolar(int x) {
        Nodo nuevo = new Nodo(x);
        if (estaVacia()) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
        System.out.println("Encolado dinámico: " + x);
    }

    // Extraer elemento del frente
    public int desencolar() {
        if (estaVacia()) {
            System.out.println("La cola está vacía.");
            return -1;
        }
        int valor = frente.dato;
        frente = frente.siguiente;
        if (frente == null) {
            fin = null;
        }
        System.out.println("Desencolado dinámico: " + valor);
        return valor;
    }

    // Método solicitado: consultar valor al frente sin desvincularlo
    public int peek() {
        if (estaVacia()) {
            System.out.println("La cola está vacía.");
            return -1;
        }
        return frente.dato;
    }

    // Método solicitado: contar nodos activos mediante un recorrido
    public int contarElementos() {
        int contador = 0;
        Nodo actual = frente;
        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }
        return contador;
    }

    // Método para mostrar elementos
    public void mostrar() {
        if (estaVacia()) {
            System.out.println("Cola vacía.");
            return;
        }
        Nodo actual = frente;
        System.out.print("Frente -> ");
        while (actual != null) {
            System.out.print("[" + actual.dato + "] ");
            actual = actual.siguiente;
        }
        System.out.println("<- Fin");
    }
}