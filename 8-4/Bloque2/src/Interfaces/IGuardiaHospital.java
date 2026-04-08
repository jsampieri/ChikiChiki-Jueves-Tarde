package Interfaces;

// Consigna 3: Guardia del Hospital de Clínicas (Triage) - Cola de PRIORIDAD
// Mayor valor entero = Mayor prioridad médica. Un raspón (1) espera, un bobazo (100) pasa primero.
// Casos de ejemplo: raspón=1, fractura=50, infarto=100
public interface IGuardiaHospital {
    void inicializarCola();
    void acolarPrioridad(String paciente, int prioridad);
    void desacolar();
    String primero();
    int prioridad();
    boolean colaVacia();

    void llegar(String paciente, int nivelUrgencia);
    String atender();
    String proximoPaciente();
    int urgenciaProximo();
    boolean estaVacia();
}
