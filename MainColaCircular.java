package estructuras_lineales.colas;

public class MainColaCircular {
    public static void main(String[] args) {
        System.out.println("=== PRUEBA: COLA ESTÁTICA CIRCULAR ===");
        ColaEstaticaCircular colaCircular = new ColaEstaticaCircular(3);

        colaCircular.enqueue(10);
        colaCircular.enqueue(20);
        colaCircular.enqueue(30);
        colaCircular.mostrar();

        // Consulta del frente con peek()
        System.out.println("Elemento al frente (peek): " + colaCircular.peek());

        // Se libera el primer espacio
        colaCircular.dequeue();
        colaCircular.mostrar();

        // Se inserta nuevamente comprobando el avance circular con módulo
        colaCircular.enqueue(40);
        colaCircular.mostrar();
    }
}