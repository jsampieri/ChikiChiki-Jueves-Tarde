package Implementacion;

import Interfaces.IEmbarqueAerolineas;

// Categorías: Movilidad Reducida = 3, Business = 2, Turista = 1
// Con misma prioridad: el orden de salida depende del índice encontrado al buscar el máximo.
// No hay desempate garantizado por orden de llegada en esta implementación.
public class EmbarqueAerolineas implements IEmbarqueAerolineas {

    public static final int MOVILIDAD_REDUCIDA = 3;
    public static final int BUSINESS = 2;
    public static final int TURISTA = 1;

    private static final int MAX = 20;
    private String[] pasajeros;
    private int[] categorias;
    private int cantidad;

    @Override
    public void inicializarCola() {
        pasajeros = new String[MAX];
        categorias = new int[MAX];
        cantidad = 0;
    }

    @Override
    public void acolarPrioridad(String pasajero, int prioridad) {
        if (cantidad < MAX) {
            pasajeros[cantidad] = pasajero;
            categorias[cantidad] = prioridad;
            cantidad++;
        }
    }

    private int indiceMaxPrioridad() {
        int max = 0;
        for (int i = 1; i < cantidad; i++)
            if (categorias[i] > categorias[max]) max = i;
        return max;
    }

    @Override
    public void desacolar() {
        if (!colaVacia()) {
            int idx = indiceMaxPrioridad();
            pasajeros[idx] = pasajeros[cantidad - 1];
            categorias[idx] = categorias[cantidad - 1];
            cantidad--;
        }
    }

    @Override
    public String primero() {
        return pasajeros[indiceMaxPrioridad()];
    }

    @Override
    public int prioridad() {
        return categorias[indiceMaxPrioridad()];
    }

    @Override
    public boolean colaVacia() {
        return cantidad == 0;
    }

    @Override
    public void abordar(String nombre, int categoria) {
        acolarPrioridad(nombre, categoria);
    }

    @Override
    public String embarcarSiguiente() {
        if (colaVacia()) return "Todos embarcados";
        String nombre = primero();
        int cat = prioridad();
        String tipo = cat == MOVILIDAD_REDUCIDA ? "Movilidad reducida" : cat == BUSINESS ? "Business" : "Turista";
        desacolar();
        return "Embarcando: " + nombre + " [" + tipo + "]";
    }

    @Override
    public String proximoPasajero() {
        if (colaVacia()) return "Nadie esperando";
        return primero();
    }

    @Override
    public boolean estaVacia() {
        return colaVacia();
    }
}
