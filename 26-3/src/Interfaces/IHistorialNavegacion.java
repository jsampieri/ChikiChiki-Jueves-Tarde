package Interfaces;

public interface IHistorialNavegacion {
    void inicializar();
    void apilar(String x);
    void desapilar();
    String tope();
    boolean pilaVacia();
    void visitar(String url);
    void atras();
    String paginaActual();
    boolean sinHistorial();
}
