package Interfaces;

// Consigna 4: Tags de un Blog de Ingeniería - CONJUNTO de tags
// Se usa Conjunto (no Pila) porque:
//   - Los tags NO tienen orden relevante (#Java no es "más importante" que #OOP).
//   - No puede haber tags duplicados (agregar #Java dos veces no tiene sentido).
//   - No necesitamos saber cuál fue el "último tag agregado" (LIFO sería innecesario).
public interface ITagsBlog {
    void inicializarConjunto();
    void agregar(String tag);
    void sacar(String tag);
    boolean pertenece(String tag);
    String elegir();
    boolean conjuntoVacio();

    void agregarTag(String tag);
    boolean tieneTag(String tag);
    void eliminarTag(String tag);
    int cantidadTags();
}
