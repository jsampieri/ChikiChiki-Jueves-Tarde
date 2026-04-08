package Implementacion;

import Interfaces.IGuardiaHospital;

public class GuardiaHospital implements IGuardiaHospital {

    private static final int MAX = 20;
    private String[] pacientes;
    private int[] urgencias;
    private int cantidad;

    @Override
    public void inicializarCola() {
        pacientes = new String[MAX];
        urgencias = new int[MAX];
        cantidad = 0;
    }

    @Override
    public void acolarPrioridad(String paciente, int prioridad) {
        if (cantidad < MAX) {
            pacientes[cantidad] = paciente;
            urgencias[cantidad] = prioridad;
            cantidad++;
        }
    }

    private int indiceMaxPrioridad() {
        int max = 0;
        for (int i = 1; i < cantidad; i++)
            if (urgencias[i] > urgencias[max]) max = i;
        return max;
    }

    @Override
    public void desacolar() {
        if (!colaVacia()) {
            int idx = indiceMaxPrioridad();
            pacientes[idx] = pacientes[cantidad - 1];
            urgencias[idx] = urgencias[cantidad - 1];
            cantidad--;
        }
    }

    @Override
    public String primero() {
        return pacientes[indiceMaxPrioridad()];
    }

    @Override
    public int prioridad() {
        return urgencias[indiceMaxPrioridad()];
    }

    @Override
    public boolean colaVacia() {
        return cantidad == 0;
    }

    @Override
    public void llegar(String paciente, int nivelUrgencia) {
        acolarPrioridad(paciente, nivelUrgencia);
    }

    @Override
    public String atender() {
        if (colaVacia()) return "Sin pacientes";
        String paciente = primero();
        int urgencia = prioridad();
        desacolar();
        return "Atendiendo a " + paciente + " (urgencia " + urgencia + ")";
    }

    @Override
    public String proximoPaciente() {
        if (colaVacia()) return "Sala vacía";
        return primero() + " (urgencia " + prioridad() + ")";
    }

    @Override
    public int urgenciaProximo() {
        if (colaVacia()) return -1;
        return prioridad();
    }

    @Override
    public boolean estaVacia() {
        return colaVacia();
    }
}
