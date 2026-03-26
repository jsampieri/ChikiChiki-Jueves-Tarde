package Interfaces;

public interface IEditorCodigo {
    void inicializar();
    void apilar(String x);
    void desapilar();
    String tope();
    boolean pilaVacia();
    void hacerCambio(String estado);
    String deshacer();
    boolean sinCambios();
}
