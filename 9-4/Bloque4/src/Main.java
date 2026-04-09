import Implementacion.*;
import Implementacion.AgendaContactos;

public class Main{
    public static void main(String[] args) {

        // === Consigna 1: Agenda de Contactos ===
        AgendaContactos agenda = new AgendaContactos();
        agenda.iniciarAgenda();
        agenda.agregarContacto("Manuel","+54 9 2346 694910");
        agenda.agregarContacto("Francisco","+54 9 11 5880-1260");
        agenda.agregarContacto("Juan","+54 9 11 5719-4603");
        agenda.agregarContacto("Santiago","+54 9 11 6909-8444");
        agenda.agregarContacto("Luka","+54 9 11 2668-4910");
        agenda.agregarContacto("Tiziano","+54 9 11 3073-3101");

        agenda.mostrarContactos();
        agenda.buscarContacto("Francisco");
        agenda.eliminarContacto("Francisco");
        agenda.buscarContacto("Francisco");
    }
}