package Implementacion;
import Interfaces.IAgenda;

public class AgendaContactos implements IAgenda {
    private String[] telefonos;
    private String[] nombres;
    private int cantidad;
    private static final int MAX=100;

    @Override
    public void iniciarAgenda() {
        telefonos = new String[MAX];
        nombres = new String[MAX];
        cantidad = 0;
    }

    private int buscarIndice(String nombre){
        for (int i=0;i<cantidad;i++){
            if (nombres[i].equals(nombre)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void agregarContacto(String nombre, String telefono) {
        int index = buscarIndice(nombre);
        if (index == -1){
            telefonos[cantidad] = telefono;
        } else {
            nombres[cantidad] = nombre;
            telefonos[cantidad] = telefono;
            cantidad++;
        }
    }

    @Override
    public void buscarContacto(String nombre) {
        int index = buscarIndice(nombre);
        if (index != -1) {
        } else  {
        }
    }

    @Override
    public void eliminarContacto(String nombre) {
        int index = buscarIndice(nombre);

        if (index != -1) {
            for (int i=index; i<cantidad; i++){
                nombres[i] = nombres[i+1];
                telefonos[i] = telefonos[i+1];
            }
            cantidad--;
        }
    }

    @Override
    public void mostrarContactos() {
    for (int i = 0; i < cantidad; i++) {
        System.out.println(nombres[i] + " -> " + telefonos [i]);
        }
    }
}
