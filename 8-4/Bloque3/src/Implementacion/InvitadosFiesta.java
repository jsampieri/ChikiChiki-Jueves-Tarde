package Implementacion;

import Interfaces.IInvitadosFiesta;

public class InvitadosFiesta implements IInvitadosFiesta {

    private static final int MAX = 100;
    private String[] datos;
    private int cantidad;

    @Override
    public void inicializarConjunto() {
        datos = new String[MAX];
        cantidad = 0;
    }

    @Override
    public void agregar(String nombre) {
        if (!pertenece(nombre) && cantidad < MAX)
            datos[cantidad++] = nombre;
        // Si ya existe: no hace nada, el tamaño NO cambia.
    }

    @Override
    public void sacar(String nombre) {
        for (int i = 0; i < cantidad; i++) {
            if (datos[i].equals(nombre)) {
                datos[i] = datos[cantidad - 1];
                cantidad--;
                return;
            }
        }
    }

    @Override
    public boolean pertenece(String nombre) {
        for (int i = 0; i < cantidad; i++)
            if (datos[i].equals(nombre)) return true;
        return false;
    }

    @Override
    public String elegir() {
        if (conjuntoVacio()) return null;
        return datos[0];
    }

    @Override
    public boolean conjuntoVacio() {
        return cantidad == 0;
    }

    @Override
    public void invitar(String nombre) {
        agregar(nombre);
    }

    @Override
    public boolean estaInvitado(String nombre) {
        return pertenece(nombre);
    }

    @Override
    public int cantidadInvitados() {
        return cantidad;
    }
}
