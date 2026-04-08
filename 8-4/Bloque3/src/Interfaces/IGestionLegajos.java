package Interfaces;

// Consigna 5: Gestión de Legajos - CONJUNTO de IDs únicos
// Si un alumno se anota a dos carreras, se usa Pertenece() para verificar
// si su legajo ya existe antes de Agregar. El Conjunto garantiza unicidad.
public interface IGestionLegajos {
    void inicializarConjunto();
    void agregar(int legajo);
    void sacar(int legajo);
    boolean pertenece(int legajo);
    int elegir();
    boolean conjuntoVacio();

    boolean registrarAlumno(int legajo);
    boolean estaRegistrado(int legajo);
    void darDeBaja(int legajo);
    int totalAlumnos();
}
