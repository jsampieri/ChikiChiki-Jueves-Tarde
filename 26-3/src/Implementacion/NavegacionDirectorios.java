package Implementacion;

import Interfaces.INavegacionDirectorios;

public class NavegacionDirectorios implements INavegacionDirectorios {

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
    public void entrar(String carpeta) {
        apilar(carpeta);
    }

    @Override
    public void subirNivel() {
        if (!pilaVacia()) desapilar();
    }

    @Override
    public String directorioActual() {
        if (pilaVacia()) return "Raíz";
        return tope();
    }

    @Override
    public boolean enRaiz() {
        return pilaVacia();
    }
}
