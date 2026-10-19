package estructuras_lineales.colas;

public class MainColaEstatica {
    public static void main(String[] args) {
        System.out.println("=== PRUEBA: COLA ESTÁTICA LINEAL ===");
        // Instancia con capacidad para 3 elementos
        ColaEstatica cola = new ColaEstatica(3);

        cola.enqueue(10);
        cola.enqueue(20);
        cola.enqueue(30);
        // Demostración de desbordamiento de capacidad
        cola.enqueue(40);
        cola.mostrar();

        // Consulta de frente sin extraer
        System.out.println("Elemento al frente (peek): " + cola.peek());

        // Extracción de elementos
        cola.dequeue();
        cola.mostrar();
    }
}