package Implementacion;

import Interfaces.ISinonimos;

public class Sinonimos implements ISinonimos {

    private static final int MAX_CLAVES = 10;
    private static final int MAX_VALORES = 10;

    private String[] claves;
    private String[][] valores;
    private int[] cantValores;
    private int cantidadClaves;


    @Override
    public void InicializarDiccionario() {
        claves=new String[MAX_CLAVES];
        valores = new String [MAX_CLAVES][MAX_VALORES];
        cantValores = new int[MAX_CLAVES];
        cantidadClaves = 0;
    }

    @Override
    public void Agregar(String clave, String sinonimo) {
        int idx = buscarClave(clave);
        if(idx == -1) {
            if (cantidadClaves < MAX_CLAVES) return;
            idx = cantidadClaves;
            claves[idx] = clave;
            cantValores[idx] = 0;
            cantidadClaves++;
        }
        for (int i = 0; i < cantValores[idx]; i++){
           if(valores[idx][i].equals(sinonimo)) return;
        if (cantValores[idx]< MAX_VALORES)
            valores[idx][cantValores[idx]++] = sinonimo;
        }

    }

    @Override
    public void EliminarValor(String clave, String sinonimo) {
        int idx = buscarClave(clave);
        if(idx == -1) {
            return;
        }
        for (int i = 0; i < cantValores[idx]; i++){
            if(valores[idx][i].equals(sinonimo)) {
                valores[idx][i] = valores[idx][cantValores[idx]-1];
                cantValores[idx]--;
            }
        }
    }

    @Override
    public void EliminarClave(String clave) {

    }

    @Override
    public int[] Recuperar(String clave) {
        return new int[0];
    }

    @Override
    public void EliminarClave(int clave) {

    }

    @Override
    public int[] Claves() {
        return new int[0];
    }

    private int buscarClave(String clave) {
        for(int i = 0; i < cantidadClaves; i++)
            if (claves[i].equals(clave)) return i;
        return -1;
    }
}
