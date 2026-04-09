package Interfaces;

public interface IAgenda {
    void iniciarAgenda ();
    void agregarContacto (String nombre, String telefono);
    void buscarContacto (String nombre);
    void eliminarContacto (String nombre);
    void mostrarContactos ();

}
