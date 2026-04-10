import Implementacion.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== Consigna 1: Padrón Electoral ===");

        AgendaContactos agenda = new AgendaContactos();

        agenda.iniciarAgenda();

        agenda.agregarContacto("Fran", "+54 9 11 4578-9854");
        agenda.agregarContacto("Manu", "+54 9 2346 694910");
        agenda.agregarContacto("Juan", "+54 9 11 1544-8785");

        System.out.println("\n--- Contactos cargados ---");
        agenda.mostrarContactos();

        System.out.println("\nBuscar Fran:");
        System.out.println(agenda.buscarContacto("Fran"));

        agenda.eliminarContacto("Fran");

        System.out.println("\n--- Contactos luego de eliminar ---");
        agenda.mostrarContactos();

        System.out.println("\nBuscar Fran nuevamente:");
        System.out.println(agenda.buscarContacto("Fran"));
    }
}
