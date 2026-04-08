package Implementacion;

import Interfaces.IElegirVsSacar;

public class ElegirVsSacar implements IElegirVsSacar {

    private static final int MAX = 50;
    private String[] datos;
    private int cantidad;

    @Override
    public void inicializarConjunto() {
        datos = new String[MAX];
        cantidad = 0;
    }

    @Override
    public void agregar(String elemento) {
        if (!pertenece(elemento) && cantidad < MAX)
            datos[cantidad++] = elemento;
    }

    @Override
    public void sacar(String elemento) {
        for (int i = 0; i < cantidad; i++) {
            if (datos[i].equals(elemento)) {
                datos[i] = datos[cantidad - 1];
                cantidad--;
                return;
            }
        }
    }

    @Override
    public boolean pertenece(String elemento) {
        for (int i = 0; i < cantidad; i++)
            if (datos[i].equals(elemento)) return true;
        return false;
    }

    @Override
    public String elegir() {
        // Arbitrario: devuelve datos[0]. No es aleatorio.
        if (conjuntoVacio()) return null;
        return datos[0];
    }

    @Override
    public boolean conjuntoVacio() {
        return cantidad == 0;
    }

    @Override
    public String verSinSacar() {
        // Elegir dos veces SIN Sacar → devuelve el mismo elemento (datos[0])
        return elegir();
    }

    @Override
    public String sacarYMostrar() {
        if (conjuntoVacio()) return "Conjunto vacío";
        String elem = elegir();
        sacar(elem);
        return elem;
    }

    @Override
    public int tamanio() {
        return cantidad;
    }
}
