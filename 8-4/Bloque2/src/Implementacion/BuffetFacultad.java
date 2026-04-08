package Implementacion;

import Interfaces.IBuffetFacultad;

// La operación Acolar es la que garantiza que nadie se cuele:
// solo permite agregar al FINAL de la fila. No existe forma de insertar en el medio.
public class BuffetFacultad implements IBuffetFacultad {

    private static final int MAX = 20;
    private String[] datos;
    private int cantidad;

    @Override
    public void inicializarCola() {
        datos = new String[MAX];
        cantidad = 0;
    }

    @Override
    public void acolar(String persona) {
        if (cantidad < MAX) datos[cantidad++] = persona;
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
    public void hacerFila(String nombre) {
        acolar(nombre);
    }

    @Override
    public String servirSiguiente() {
        if (colaVacia()) return "No hay nadie en la fila";
        String persona = primero();
        desacolar();
        return "Sirviendo a: " + persona;
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
