package Interfaces;

// Consigna 2: Impresora del Laboratorio - Cola COMÚN (FIFO)
// El archivo que llega primero se imprime primero.
public interface IImpresoraLaboratorio {
    void inicializarCola();
    void acolar(String archivo);
    void desacolar();
    String primero();
    boolean colaVacia();

    void recibirArchivo(String nombre);
    String imprimir();
    String proximoArchivo();
    boolean estaVacia();
}
