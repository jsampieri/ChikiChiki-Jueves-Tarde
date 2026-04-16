import Implementacion.PilaDinamica;
import Implementacion.PilaEstatica;

public class Main {
    public static void main(String[] args) {

            PilaEstatica pila1=new PilaEstatica();

            pila1.InicializarPila();
            for(int i=1; i<=100;i++){
                pila1.Apilar(i);
            }

            PilaEstatica pilaAux=new PilaEstatica();

            pilaAux.InicializarPila();

            while(!pila1.PilaVacia()){
                pilaAux.Apilar(pila1.Tope());
                pila1.Desapilar();
            }

            System.out.println("Pila aux tope (invertida de pila 1) " + pilaAux.Tope());

            PilaDinamica pila2=new PilaDinamica();

            pila2.InicializarPila();

            while (!pilaAux.PilaVacia()){
                pila2.Apilar(pilaAux.Tope());
                pilaAux.Desapilar();
            }

            System.out.println("Pila 2 tope (invertida de pilaAux) " + pila2.Tope());
        }
    }

