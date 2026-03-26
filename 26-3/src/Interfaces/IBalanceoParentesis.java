package Interfaces;

public interface IBalanceoParentesis {
    void inicializar();
    void apilar(String x);
    void desapilar();
    boolean pilaVacia();
    boolean estaBalanceada(String expresion);
}
