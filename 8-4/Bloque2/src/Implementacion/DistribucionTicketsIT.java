package Implementacion;

import Interfaces.IDistribucionTicketsIT;

// Criticidades: Servidor principal caído = 999, fondo de pantalla = 0
public class DistribucionTicketsIT implements IDistribucionTicketsIT {

    private static final int MAX = 20;
    private String[] descripciones;
    private int[] criticidades;
    private int cantidad;

    @Override
    public void inicializarCola() {
        descripciones = new String[MAX];
        criticidades = new int[MAX];
        cantidad = 0;
    }

    @Override
    public void acolarPrioridad(String descripcion, int prioridad) {
        if (cantidad < MAX) {
            descripciones[cantidad] = descripcion;
            criticidades[cantidad] = prioridad;
            cantidad++;
        }
    }

    private int indiceMaxPrioridad() {
        int max = 0;
        for (int i = 1; i < cantidad; i++)
            if (criticidades[i] > criticidades[max]) max = i;
        return max;
    }

    @Override
    public void desacolar() {
        if (!colaVacia()) {
            int idx = indiceMaxPrioridad();
            descripciones[idx] = descripciones[cantidad - 1];
            criticidades[idx] = criticidades[cantidad - 1];
            cantidad--;
        }
    }

    @Override
    public String primero() {
        return descripciones[indiceMaxPrioridad()];
    }

    @Override
    public int prioridad() {
        return criticidades[indiceMaxPrioridad()];
    }

    @Override
    public boolean colaVacia() {
        return cantidad == 0;
    }

    @Override
    public void reportarTicket(String descripcion, int nivelCriticidad) {
        acolarPrioridad(descripcion, nivelCriticidad);
    }

    @Override
    public String atenderTicket() {
        if (colaVacia()) return "Sin tickets";
        String desc = primero();
        int crit = prioridad();
        desacolar();
        return "[Ticket criticidad " + crit + "] " + desc;
    }

    @Override
    public String ticketActual() {
        if (colaVacia()) return "Sin tickets pendientes";
        return primero();
    }

    @Override
    public int criticidadActual() {
        if (colaVacia()) return -1;
        return prioridad();
    }

    @Override
    public boolean estaVacia() {
        return colaVacia();
    }
}
