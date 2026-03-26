package Implementacion;

import Interfaces.IHistorialNavegacion;

public class HistorialNavegacion implements IHistorialNavegacion {

    private static final int MAX = 3;
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
    public void visitar(String url) {
        apilar(url);
    }

    @Override
    public void atras() {
        if (!pilaVacia()) desapilar();
    }

    @Override
    public String paginaActual() {
        if (pilaVacia()) return "Sin páginas";
        return tope();
    }

    @Override
    public boolean sinHistorial() {
        return pilaVacia();
    }
}
