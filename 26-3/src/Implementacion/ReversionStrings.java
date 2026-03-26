package Implementacion;

import Interfaces.IReversionStrings;

public class ReversionStrings implements IReversionStrings {

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
    public String invertir(String texto) {
        inicializar();
        for (int i = 0; i < texto.length(); i++) {
            apilar(String.valueOf(texto.charAt(i)));
        }
        String resultado = "";
        while (!pilaVacia()) {
            resultado += tope();
            desapilar();
        }
        return resultado;
    }
}
