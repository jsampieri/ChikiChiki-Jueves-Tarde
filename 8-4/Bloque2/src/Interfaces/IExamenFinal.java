package Interfaces;

// Consigna 4: Examen Final - Cola de PRIORIDAD
// Promocionados (prioridad 10) pasan antes que Regulares (prioridad 5).
// Un regular que llegó antes cede su lugar al promocionado al hacer Desacolar.
public interface IExamenFinal {
    void inicializarCola();
    void acolarPrioridad(String alumno, int prioridad);
    void desacolar();
    String primero();
    int prioridad();
    boolean colaVacia();

    void anotarse(String nombre, int condicion);
    String llamarSiguiente();
    String proximoAlumno();
    boolean estaVacia();
}
