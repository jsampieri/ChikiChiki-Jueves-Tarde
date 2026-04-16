package Implementacion;

public class Nodo {
    private int dato;
    private Nodo next;

    public Nodo(int x, Nodo tope) {
        this.dato=x;
        this.next=tope;
    }

    public Nodo getNext() {
        return next;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }
}
