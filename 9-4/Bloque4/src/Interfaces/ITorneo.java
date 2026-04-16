package Interfaces;
public interface ITorneo {

    void iniciarTorneo ();
    void agregarUsuarios(String usuario, int puntaje);
    int buscarUsuario (String usuario);
    void eliminarUsuario (String usuario);
    void mostrarUsusarios ();
    int puntajeMaximo();
    
}
