package Interfaces;

public interface IPilaLlamadas {
    void inicializar();
    void apilar(String x);
    void desapilar();
    String tope();
    boolean pilaVacia();
    void llamar(String funcion);
    void retornar();
    String funcionActual();
    boolean vacia();
}
