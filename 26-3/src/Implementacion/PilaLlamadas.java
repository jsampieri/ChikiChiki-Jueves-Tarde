package Implementacion;

import Interfaces.IPilaLlamadas;

public class PilaLlamadas implements IPilaLlamadas {

    private static final int MAX = 100;
    private String[] datos;
    private int cantidad;

    @Override
    public void inicializar() {
        datos = new String[MAX + 1];
        cantidad = 0;
    }

    @Override
    public void apilar(String x) {
        if (cantidad < MAX) {
            cantidad++;
            datos[cantidad] = x;
        }
    }

    @Override
    public void desapilar() {
        if (!pilaVacia()) cantidad--;
    }

    @Override
    public String tope() {
        return datos[cantidad];
    }

    @Override
    public boolean pilaVacia() {
        return cantidad == 0;
    }

    @Override
    public void llamar(String funcion) {
        apilar(funcion);
    }

    @Override
    public void retornar() {
        if (!pilaVacia()) desapilar();
    }

    @Override
    public String funcionActual() {
        if (pilaVacia()) return "Sin función en ejecución";
        return tope();
    }

    @Override
    public boolean vacia() {
        return pilaVacia();
    }
}
