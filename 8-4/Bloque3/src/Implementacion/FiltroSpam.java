package Implementacion;

import Interfaces.IFiltroSpam;

public class FiltroSpam implements IFiltroSpam {

    private static final int MAX = 100;
    private String[] palabrasProhibidas;
    private int cantidad;

    @Override
    public void inicializarConjunto() {
        palabrasProhibidas = new String[MAX];
        cantidad = 0;
    }

    @Override
    public void agregar(String palabra) {
        if (!pertenece(palabra) && cantidad < MAX)
            palabrasProhibidas[cantidad++] = palabra.toLowerCase();
    }

    @Override
    public void sacar(String palabra) {
        String p = palabra.toLowerCase();
        for (int i = 0; i < cantidad; i++) {
            if (palabrasProhibidas[i].equals(p)) {
                palabrasProhibidas[i] = palabrasProhibidas[cantidad - 1];
                cantidad--;
                return;
            }
        }
    }

    @Override
    public boolean pertenece(String palabra) {
        String p = palabra.toLowerCase();
        for (int i = 0; i < cantidad; i++)
            if (palabrasProhibidas[i].equals(p)) return true;
        return false;
    }

    @Override
    public String elegir() {
        if (conjuntoVacio()) return null;
        return palabrasProhibidas[0];
    }

    @Override
    public boolean conjuntoVacio() {
        return cantidad == 0;
    }

    @Override
    public void agregarPalabraProhibida(String palabra) {
        agregar(palabra);
    }

    @Override
    public boolean esSpam(String texto) {
        // Tokenizar por espacios y verificar cada palabra con Pertenece()
        String[] tokens = texto.toLowerCase().split("\\s+");
        for (String token : tokens)
            if (pertenece(token)) return true;
        return false;
    }

    @Override
    public void eliminarPalabra(String palabra) {
        sacar(palabra);
    }
}
