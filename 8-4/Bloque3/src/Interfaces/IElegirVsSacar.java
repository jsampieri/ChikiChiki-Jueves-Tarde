package Interfaces;

// Consigna 6: Operación Elegir vs Sacar
// Elegir: devuelve un elemento arbitrario SIN eliminarlo del conjunto.
// Si llamás Elegir dos veces sin Sacar, PUEDE devolver el mismo elemento (arbitrario,
// no necesariamente aleatorio). En esta implementación de arreglo, siempre devuelve datos[0].
// Sacar: elimina el elemento del conjunto. Tras Sacar, Elegir puede devolver otro elemento.
public interface IElegirVsSacar {
    void inicializarConjunto();
    void agregar(String elemento);
    void sacar(String elemento);
    boolean pertenece(String elemento);
    String elegir();
    boolean conjuntoVacio();

    String verSinSacar();
    String sacarYMostrar();
    int tamanio();
}
