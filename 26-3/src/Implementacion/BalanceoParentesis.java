package Implementacion;

import Interfaces.IBalanceoParentesis;

public class BalanceoParentesis implements IBalanceoParentesis {

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
    public boolean pilaVacia() {
        return cantidad == 0;
    }

    @Override
    public boolean estaBalanceada(String expresion) {
        inicializar();
        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);
            if (c == '(') {
                apilar("(");
            } else if (c == ')') {
                if (pilaVacia()) return false;
                desapilar();
            }
        }
        return pilaVacia();
    }
}
