package Interfaces;

// Consigna 2: Invitados a la Fiesta de Fin de Cursada - CONJUNTO de Strings
// Si intentás Agregar a alguien que ya está: no cambia nada. El tamaño NO aumenta.
// El Conjunto simplemente ignora el duplicado (operación Agregar es idempotente).
public interface IInvitadosFiesta {
    void inicializarConjunto();
    void agregar(String nombre);
    void sacar(String nombre);
    boolean pertenece(String nombre);
    String elegir();
    boolean conjuntoVacio();

    void invitar(String nombre);
    boolean estaInvitado(String nombre);
    int cantidadInvitados();
}
