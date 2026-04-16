package Implementacion;

import Interfaces.PilaTDA;

public class PilaDinamica implements PilaTDA {

    private Nodo tope;

    @Override
    public void InicializarPila() {
        tope = null;

    }

    @Override
    public void Apilar(int x) {
        Nodo nodo = new Nodo(x,tope);
        tope = nodo;
    }

    @Override
    public void Desapilar() {
        if (!PilaVacia()){
            tope = tope.getNext();
        }
    }

    @Override
    public int Tope() {
        return tope.getDato();
    }

    @Override
    public boolean PilaVacia() {
        return tope == null;
    }
}
