package Implementacion;

import java.util.PriorityQueue;
import java.util.Stack;

class Paciente implements Comparable<Paciente> {
    String nombre;
    int prioridad;
    Stack<String> historial;

    public Paciente(String nombre, int prioridad) {
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.historial = new Stack<>();
    }

    @Override
    public int compareTo(Paciente otro) {
        return otro.prioridad - this.prioridad;
    }
}

public class HospitalPremium {

    private PriorityQueue<Paciente> cola;

    public HospitalPremium() {
        cola = new PriorityQueue<>();
    }

    public void agregarPaciente(String nombre, int prioridad) {
        cola.add(new Paciente(nombre, prioridad));
    }

    public Paciente atenderPaciente() {
        return cola.poll();
    }

    public static void main(String[] args) {
        HospitalPremium hospital = new HospitalPremium();

        hospital.agregarPaciente("Juan", 1);
        hospital.agregarPaciente("Carlos", 100);

        Paciente p = hospital.atenderPaciente();
        System.out.println("Atendido: " + p.nombre);
    }
}