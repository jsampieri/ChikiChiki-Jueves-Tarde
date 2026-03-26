package Interfaces;

public interface IReversionStrings {
    void inicializar();
    void apilar(String x);
    void desapilar();
    String tope();
    boolean pilaVacia();
    String invertir(String texto);
}
