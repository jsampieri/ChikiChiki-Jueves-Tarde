package Implementacion;

import Interfaces.ITagsBlog;

public class TagsBlog implements ITagsBlog {

    private static final int MAX = 50;
    private String[] datos;
    private int cantidad;

    @Override
    public void inicializarConjunto() {
        datos = new String[MAX];
        cantidad = 0;
    }

    @Override
    public void agregar(String tag) {
        if (!pertenece(tag) && cantidad < MAX)
            datos[cantidad++] = tag;
    }

    @Override
    public void sacar(String tag) {
        for (int i = 0; i < cantidad; i++) {
            if (datos[i].equals(tag)) {
                datos[i] = datos[cantidad - 1];
                cantidad--;
                return;
            }
        }
    }

    @Override
    public boolean pertenece(String tag) {
        for (int i = 0; i < cantidad; i++)
            if (datos[i].equals(tag)) return true;
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
    public void agregarTag(String tag) {
        agregar(tag);
    }

    @Override
    public boolean tieneTag(String tag) {
        return pertenece(tag);
    }

    @Override
    public void eliminarTag(String tag) {
        sacar(tag);
    }

    @Override
    public int cantidadTags() {
        return cantidad;
    }
}
