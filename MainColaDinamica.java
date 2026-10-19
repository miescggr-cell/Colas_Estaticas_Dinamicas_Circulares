package estructuras_lineales.colas;

public class MainColaDinamica {
    public static void main(String[] args) {
        System.out.println("=== PRUEBA: COLA DINÁMICA ===");
        colaDinamica cola = new colaDinamica();

        cola.encolar(10);
        cola.encolar(20);
        cola.encolar(30);
        cola.encolar(40);
        cola.mostrar();

        // Validación de métodos analíticos requeridos
        System.out.println("Total de elementos activos: " + cola.contarElementos());
        System.out.println("Elemento al frente (peek): " + cola.peek());

        cola.desencolar();
        cola.mostrar();
        System.out.println("Total tras desencolar: " + cola.contarElementos());
    }
}