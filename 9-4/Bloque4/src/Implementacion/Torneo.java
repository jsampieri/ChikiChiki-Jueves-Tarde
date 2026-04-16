package Implementacion;
import Interfaces.ITorneo;

public class Torneo implements ITorneo{
    private int[] puntajes;
    private String[] usuarios;
    private int cantidad;
    private static final int max = 100;

    @Override
    public void iniciarTorneo() {
        usuarios = new String[max];
        puntajes = new int[max];
        cantidad = 0;
    }
    private int buscarIndice(String usuario){
        for (int i=0;i<cantidad;i++){
            if (usuarios[i].equals(usuario)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void agregarUsuarios(String usuario, int puntaje) {
        int index = buscarIndice(usuario);

        if (index != -1) {
            puntajes[index] = puntaje;
        } else {
            if (cantidad < max) {
                usuarios[cantidad] = usuario;
                puntajes[cantidad] = puntaje;
                cantidad++;
            } else {
                System.out.println("Torneo lleno");
        }
    }
}


    @Override
    public int buscarUsuario(String usuario) {
        int index = buscarIndice(usuario);

        if (index != -1) {
            return puntajes[index];
        } else {
            return -1;
        }
    }

    @Override
    public void eliminarUsuario(String usuario) {
        int index = buscarIndice(usuario);

        if (index != -1) {
            for (int i = index; i < cantidad - 1; i++) {
                usuarios[i] = usuarios[i + 1];
                puntajes[i] = puntajes[i + 1];
            }

            usuarios[cantidad - 1] = null;
            puntajes[cantidad - 1] = 0;

            cantidad--;
        }
    }

    @Override
    public void mostrarUsusarios() {
        for (int i = 0; i < cantidad; i++) {
        System.out.println(usuarios[i] + " -> " + puntajes [i]);
    }
    
    }
    @Override
    public int puntajeMaximo() {
        if (cantidad==0) 
            return -1; 
        int maximo = puntajes[0];
        for (int i=1;i<cantidad;i++) {
            if (puntajes[i]>maximo) {
                maximo=puntajes[i];
            }
        }
        return maximo;
    }

    }


