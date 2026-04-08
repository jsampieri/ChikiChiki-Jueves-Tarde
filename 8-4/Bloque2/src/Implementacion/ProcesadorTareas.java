package Implementacion;

import Interfaces.IProcesadorTareas;

// Prioridades: Sistema = 50, Usuario/Spotify = 10
// Si el sistema se sobrecarga, los procesos de usuario quedan bloqueados
// porque los del sistema siempre salen primero al hacer Desacolar.
public class ProcesadorTareas implements IProcesadorTareas {

    private static final int MAX = 20;
    private String[] procesos;
    private int[] prioridades;
    private int cantidad;

    @Override
    public void inicializarCola() {
        procesos = new String[MAX];
        prioridades = new int[MAX];
        cantidad = 0;
    }

    @Override
    public void acolarPrioridad(String proceso, int prioridad) {
        if (cantidad < MAX) {
            procesos[cantidad] = proceso;
            prioridades[cantidad] = prioridad;
            cantidad++;
        }
    }

    private int indiceMaxPrioridad() {
        int max = 0;
        for (int i = 1; i < cantidad; i++)
            if (prioridades[i] > prioridades[max]) max = i;
        return max;
    }

    @Override
    public void desacolar() {
        if (!colaVacia()) {
            int idx = indiceMaxPrioridad();
            procesos[idx] = procesos[cantidad - 1];
            prioridades[idx] = prioridades[cantidad - 1];
            cantidad--;
        }
    }

    @Override
    public String primero() {
        return procesos[indiceMaxPrioridad()];
    }

    @Override
    public int prioridad() {
        return prioridades[indiceMaxPrioridad()];
    }

    @Override
    public boolean colaVacia() {
        return cantidad == 0;
    }

    @Override
    public void agregarProceso(String nombre, int nivelPrioridad) {
        acolarPrioridad(nombre, nivelPrioridad);
    }

    @Override
    public String ejecutarSiguiente() {
        if (colaVacia()) return "Sin procesos en cola";
        String proceso = primero();
        int pri = prioridad();
        desacolar();
        return "Ejecutando: " + proceso + " (prioridad " + pri + ")";
    }

    @Override
    public String procesoActual() {
        if (colaVacia()) return "Ninguno";
        return primero();
    }

    @Override
    public int prioridadActual() {
        if (colaVacia()) return -1;
        return prioridad();
    }

    @Override
    public boolean estaVacia() {
        return colaVacia();
    }
}
