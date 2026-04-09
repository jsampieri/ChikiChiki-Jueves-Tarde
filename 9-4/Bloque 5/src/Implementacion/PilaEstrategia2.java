package Implementacion;

public class PilaEstrategia2 {

    private int[] pila;
    private int tamaño;

    public PilaEstrategia2(int tamañoMax) {
        pila = new int[tamañoMax];
        tamaño = 0;
    }

    public void push(int valor) {
        for (int i = tamaño; i > 0; i--) {
            pila[i] = pila[i - 1];
        }
        pila[0] = valor;
        tamaño++;
    }

    public int pop() {
        int valor = pila[0];
        for (int i = 0; i < tamaño - 1; i++) {
            pila[i] = pila[i + 1];
        }
        tamaño--;
        return valor;
    }

    public static void main(String[] args) {
        PilaEstrategia2 pila = new PilaEstrategia2(10);

        pila.push(1);
        pila.push(2);
        pila.push(3);

        System.out.println(pila.pop()); // debería dar 3
    }
}