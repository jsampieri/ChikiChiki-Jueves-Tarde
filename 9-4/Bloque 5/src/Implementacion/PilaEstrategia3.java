package Implementacion;

public class PilaEstrategia3 {

    private int[] pila;

    public PilaEstrategia3(int tamaño) {
        pila = new int[tamaño];
        pila[0] = 0; // guarda la cantidad de elementos
    }

    public void push(int valor) {
        pila[0]++;
        pila[pila[0]] = valor;
    }

    public int pop() {
        int valor = pila[pila[0]];
        pila[0]--;
        return valor;
    }

    public static void main(String[] args) {
        PilaEstrategia3 pila = new PilaEstrategia3(10);

        pila.push(5);
        pila.push(10);

        System.out.println(pila.pop()); // debería dar 10
    }
}