package Implementacion;

import Interfaces.IEditorCodigo;

public class EditorCodigo implements IEditorCodigo {

    private static final int MAX = 2;
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
    public void hacerCambio(String estado) {
        apilar(estado);
    }

    @Override
    public String deshacer() {
        if (pilaVacia()) return "Sin cambios para deshacer";
        String estado = tope();
        desapilar();
        return estado;
    }

    @Override
    public boolean sinCambios() {
        return pilaVacia();
    }
}
