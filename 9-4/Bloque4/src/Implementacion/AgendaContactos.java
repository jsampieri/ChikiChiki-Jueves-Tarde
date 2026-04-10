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
        if (index != -1) {
            // ya existe → reemplazo
            telefonos[index] = telefono;
        } else {
            // nuevo → agrego
            nombres[cantidad] = nombre;
            telefonos[cantidad] = telefono;
            cantidad++;
        }
    }

    @Override
    public String buscarContacto(String nombre) {
        int index = buscarIndice(nombre);

        if (index != -1) {
            return telefonos[index];
        } else {
            return null;
        }
    }

    public void eliminarContacto(String nombre) {
        int index = buscarIndice(nombre);

        if (index != -1) {
            for (int i = index; i < cantidad - 1; i++) {
                nombres[i] = nombres[i + 1];
                telefonos[i] = telefonos[i + 1];
            }

            // limpiar última posición (clave)
            nombres[cantidad - 1] = null;
            telefonos[cantidad - 1] = null;

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
