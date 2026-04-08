package Implementacion;

import Interfaces.IPadronElectoral;

public class PadronElectoral implements IPadronElectoral {

    private static final int MAX = 100;
    private int[] datos;
    private int cantidad;

    @Override
    public void inicializarConjunto() {
        datos = new int[MAX];
        cantidad = 0;
    }

    @Override
    public void agregar(int legajo) {
        if (!pertenece(legajo) && cantidad < MAX)
            datos[cantidad++] = legajo;
    }

    @Override
    public void sacar(int legajo) {
        for (int i = 0; i < cantidad; i++) {
            if (datos[i] == legajo) {
                datos[i] = datos[cantidad - 1];
                cantidad--;
                return;
            }
        }
    }

    @Override
    public boolean pertenece(int legajo) {
        for (int i = 0; i < cantidad; i++)
            if (datos[i] == legajo) return true;
        return false;
    }

    @Override
    public int elegir() {
        return datos[0];
    }

    @Override
    public boolean conjuntoVacio() {
        return cantidad == 0;
    }

    @Override
    public boolean registrarVoto(int legajo) {
        if (pertenece(legajo)) return false; // ya votó
        agregar(legajo);
        return true;
    }

    @Override
    public boolean yaVoto(int legajo) {
        return pertenece(legajo);
    }

    @Override
    public int totalVotantes() {
        return cantidad;
    }
}
