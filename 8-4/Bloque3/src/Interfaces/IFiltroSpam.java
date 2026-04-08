package Interfaces;

// Consigna 3: Filtro de Spam (Blacklist) - CONJUNTO de palabras prohibidas
// Para verificar si un mail es spam: se tokeniza el texto y se usa Pertenece()
// con cada palabra. Si alguna pertenece a la blacklist, es spam.
public interface IFiltroSpam {
    void inicializarConjunto();
    void agregar(String palabra);
    void sacar(String palabra);
    boolean pertenece(String palabra);
    String elegir();
    boolean conjuntoVacio();

    void agregarPalabraProhibida(String palabra);
    boolean esSpam(String texto);
    void eliminarPalabra(String palabra);
}
