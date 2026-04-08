package Implementacion;

import Interfaces.IGestionLegajos;

public class GestionLegajos implements IGestionLegajos {

    private static final int MAX = 1000;
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
    public boolean registrarAlumno(int legajo) {
        if (pertenece(legajo)) return false; // ya registrado, no duplicar
        agregar(legajo);
        return true;
    }

    @Override
    public boolean estaRegistrado(int legajo) {
        return pertenece(legajo);
    }

    @Override
    public void darDeBaja(int legajo) {
        sacar(legajo);
    }

    @Override
    public int totalAlumnos() {
        return cantidad;
    }
}
