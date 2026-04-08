package Implementacion;

import Interfaces.IExamenFinal;

// Prioridades: PROMOCIONADO = 10, REGULAR = 5
public class ExamenFinal implements IExamenFinal {

    public static final int PROMOCIONADO = 10;
    public static final int REGULAR = 5;

    private static final int MAX = 20;
    private String[] alumnos;
    private int[] condiciones;
    private int cantidad;

    @Override
    public void inicializarCola() {
        alumnos = new String[MAX];
        condiciones = new int[MAX];
        cantidad = 0;
    }

    @Override
    public void acolarPrioridad(String alumno, int prioridad) {
        if (cantidad < MAX) {
            alumnos[cantidad] = alumno;
            condiciones[cantidad] = prioridad;
            cantidad++;
        }
    }

    private int indiceMaxPrioridad() {
        int max = 0;
        for (int i = 1; i < cantidad; i++)
            if (condiciones[i] > condiciones[max]) max = i;
        return max;
    }

    @Override
    public void desacolar() {
        if (!colaVacia()) {
            int idx = indiceMaxPrioridad();
            alumnos[idx] = alumnos[cantidad - 1];
            condiciones[idx] = condiciones[cantidad - 1];
            cantidad--;
        }
    }

    @Override
    public String primero() {
        return alumnos[indiceMaxPrioridad()];
    }

    @Override
    public int prioridad() {
        return condiciones[indiceMaxPrioridad()];
    }

    @Override
    public boolean colaVacia() {
        return cantidad == 0;
    }

    @Override
    public void anotarse(String nombre, int condicion) {
        acolarPrioridad(nombre, condicion);
    }

    @Override
    public String llamarSiguiente() {
        if (colaVacia()) return "No hay más alumnos";
        String tipo = prioridad() == PROMOCIONADO ? "Promocionado" : "Regular";
        String nombre = primero();
        desacolar();
        return nombre + " (" + tipo + ")";
    }

    @Override
    public String proximoAlumno() {
        if (colaVacia()) return "Lista vacía";
        String tipo = prioridad() == PROMOCIONADO ? "Promocionado" : "Regular";
        return primero() + " [" + tipo + "]";
    }

    @Override
    public boolean estaVacia() {
        return colaVacia();
    }
}
