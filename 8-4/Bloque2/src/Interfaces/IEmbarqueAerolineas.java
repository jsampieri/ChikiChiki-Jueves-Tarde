package Interfaces;

// Consigna 7: Embarque de Aerolíneas - Cola de PRIORIDAD
// Movilidad reducida (3) > Business (2) > Turista/Mortales (1).
// Si dos pasajeros tienen la MISMA prioridad: el orden de salida es indeterminado
// (depende del índice encontrado al buscar el máximo). No hay desempate por llegada.
public interface IEmbarqueAerolineas {
    void inicializarCola();
    void acolarPrioridad(String pasajero, int prioridad);
    void desacolar();
    String primero();
    int prioridad();
    boolean colaVacia();

    void abordar(String nombre, int categoria);
    String embarcarSiguiente();
    String proximoPasajero();
    boolean estaVacia();
}
