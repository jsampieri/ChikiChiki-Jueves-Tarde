package Interfaces;

// Consigna 6: Procesador de Tareas (OS Scheduler) - Cola de PRIORIDAD
// Procesos del sistema (prioridad 50) se ejecutan antes que los del usuario (prioridad 10).
// Si el sistema se sobrecarga: los procesos del usuario quedan en espera hasta que
// los del sistema terminen, porque siempre salen primero al hacer Desacolar.
public interface IProcesadorTareas {
    void inicializarCola();
    void acolarPrioridad(String proceso, int prioridad);
    void desacolar();
    String primero();
    int prioridad();
    boolean colaVacia();

    void agregarProceso(String nombre, int nivelPrioridad);
    String ejecutarSiguiente();
    String procesoActual();
    int prioridadActual();
    boolean estaVacia();
}
