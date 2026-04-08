package Interfaces;

// Consigna 1: Fila del Cajero - Cola COMÚN (FIFO)
// El orden de llegada determina el orden de atención. No hay privilegios.
public interface IFilaCajero {
    void inicializarCola();
    void acolar(String cliente);
    void desacolar();
    String primero();
    boolean colaVacia();

    void llegaCliente(String nombre);
    String atender();
    String primeroEnFila();
    boolean estaVacia();
}
