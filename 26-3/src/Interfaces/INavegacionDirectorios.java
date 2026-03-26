package Interfaces;

public interface INavegacionDirectorios {
    void inicializar();
    void apilar(String x);
    void desapilar();
    String tope();
    boolean pilaVacia();
    void entrar(String carpeta);
    void subirNivel();
    String directorioActual();
    boolean enRaiz();
}
