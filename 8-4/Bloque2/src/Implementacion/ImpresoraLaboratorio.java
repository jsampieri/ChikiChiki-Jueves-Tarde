package Implementacion;

import Interfaces.IImpresoraLaboratorio;

public class ImpresoraLaboratorio implements IImpresoraLaboratorio {

    private static final int MAX = 20;
    private String[] datos;
    private int cantidad;

    @Override
    public void inicializarCola() {
        datos = new String[MAX];
        cantidad = 0;
    }

    @Override
    public void acolar(String archivo) {
        if (cantidad < MAX) datos[cantidad++] = archivo;
    }

    @Override
    public void desacolar() {
        if (!colaVacia()) {
            for (int i = 0; i < cantidad - 1; i++) datos[i] = datos[i + 1];
            cantidad--;
        }
    }

    @Override
    public String primero() {
        return datos[0];
    }

    @Override
    public boolean colaVacia() {
        return cantidad == 0;
    }

    @Override
    public void recibirArchivo(String nombre) {
        acolar(nombre);
    }

    @Override
    public String imprimir() {
        if (colaVacia()) return "Sin archivos en cola";
        String archivo = primero();
        desacolar();
        return "Imprimiendo: " + archivo;
    }

    @Override
    public String proximoArchivo() {
        if (colaVacia()) return "Cola vacía";
        return primero();
    }

    @Override
    public boolean estaVacia() {
        return colaVacia();
    }
}
