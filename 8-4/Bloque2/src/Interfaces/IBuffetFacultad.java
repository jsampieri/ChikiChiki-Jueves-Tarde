package Interfaces;

// Consigna 5: Buffet de la Facultad - Cola COMÚN (FIFO)
// Operación clave: Acolar garantiza que el que llega al final de la fila
// no puede "colarse" delante de nadie. El orden es estricto FIFO.
public interface IBuffetFacultad {
    void inicializarCola();
    void acolar(String persona);
    void desacolar();
    String primero();
    boolean colaVacia();

    void hacerFila(String nombre);
    String servirSiguiente();
    String primeroEnFila();
    boolean estaVacia();
}
