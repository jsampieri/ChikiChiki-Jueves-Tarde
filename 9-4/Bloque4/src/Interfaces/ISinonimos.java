package Interfaces;

public interface ISinonimos {

    void InicializarDiccionario();
    void Agregar(String clave, String sinonimo);
    void EliminarValor(String clave, String sinonimo);
    void EliminarClave(String clave);
    int[] Recuperar(String clave);

    void EliminarClave(int clave);

    int[] Claves();

}