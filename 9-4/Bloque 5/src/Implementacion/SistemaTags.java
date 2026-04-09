package Implementacion;

import java.util.*;

public class SistemaTags {

    private Map<String, Set<String>> carreras;

    public SistemaTags() {
        carreras = new HashMap<>();
    }

    public void agregarCarrera(String nombre) {
        carreras.put(nombre, new HashSet<>());
    }

    public void agregarMateria(String carrera, String materia) {
        carreras.get(carrera).add(materia);
    }

    public Set<String> obtenerMaterias(String carrera) {
        return carreras.get(carrera);
    }

    public static void main(String[] args) {
        SistemaTags sistema = new SistemaTags();

        sistema.agregarCarrera("Bioinformatica");
        sistema.agregarMateria("Bioinformatica", "Algoritmos");
        sistema.agregarMateria("Bioinformatica", "Matematica");

        System.out.println(sistema.obtenerMaterias("Bioinformatica"));
    }
}
