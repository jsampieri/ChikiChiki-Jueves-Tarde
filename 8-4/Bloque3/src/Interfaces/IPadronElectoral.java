package Interfaces;

// Consigna 1: Padrón Electoral - CONJUNTO de legajos
// Pertenece() es la operación clave para evitar que alguien vote dos veces.
// Antes de registrar el voto, se verifica si el legajo ya está en el conjunto.
public interface IPadronElectoral {
    void inicializarConjunto();
    void agregar(int legajo);
    void sacar(int legajo);
    boolean pertenece(int legajo);
    int elegir();
    boolean conjuntoVacio();

    boolean registrarVoto(int legajo);
    boolean yaVoto(int legajo);
    int totalVotantes();
}
