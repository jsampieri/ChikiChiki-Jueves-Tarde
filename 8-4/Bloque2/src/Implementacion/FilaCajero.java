package Implementacion;

import Interfaces.IFilaCajero;

public class FilaCajero implements IFilaCajero {

    private static final int MAX = 20;
    private String[] datos;
    private int cantidad;

    @Override
    public void inicializarCola() {
        datos = new String[MAX];
        cantidad = 0;
    }

    @Override
    public void acolar(String cliente) {
        if (cantidad < MAX) datos[cantidad++] = cliente;
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
    public void llegaCliente(String nombre) {
        acolar(nombre);
    }

    @Override
    public String atender() {
        if (colaVacia()) return "Fila vacía";
        String cliente = primero();
        desacolar();
        return "Atendiendo a: " + cliente;
    }

    @Override
    public String primeroEnFila() {
        if (colaVacia()) return "Fila vacía";
        return primero();
    }

    @Override
    public boolean estaVacia() {
        return colaVacia();
    }
}
