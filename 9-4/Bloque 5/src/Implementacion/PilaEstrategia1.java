package Implementacion;

public class PilaEstrategia1 {

    private int[] pila;
    private int tope;

    public PilaEstrategia1(int tamaño) {
        pila = new int[tamaño];
        tope = 0;
    }

    public void push(int valor) {
        pila[tope] = valor;
        tope++;
    }

    public int pop() {
        tope--;
        return pila[tope];
    }

    public static void main(String[] args) {
        PilaEstrategia1 pila = new PilaEstrategia1(10);

        pila.push(1);
        pila.push(2);

        System.out.println(pila.pop());
    }
}