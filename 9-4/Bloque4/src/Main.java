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

        System.out.println("=== Consigna 2: Sinonimos ===");

        Sinonimos dic = new Sinonimos();

        dic.InicializarDiccionario();

        // Agregar datos
        dic.Agregar("feliz", "contento");
        dic.Agregar("feliz", "alegre");
        dic.Agregar("feliz", "animado");

        dic.Agregar("triste", "deprimido");
        dic.Agregar("triste", "melancolico");

        // Mostrar claves
        System.out.println("\nClaves actuales:");
        String[] claves = dic.Claves();
        for (int i = 0; i < claves.length; i++) {
            System.out.println("Clave: " + claves[i]);
        }

        // Mostrar sinónimos de "feliz"
        System.out.println("\nSinónimos de 'feliz':");
        String[] sinonimos = dic.CopiaSinonimoClave("feliz");
        for (int i = 0; i < sinonimos.length; i++) {
            System.out.println("- " + sinonimos[i]);
        }

        // Eliminar un sinónimo
        System.out.println("\nEliminando 'alegre' de 'feliz'...");
        dic.EliminarValor("feliz", "alegre");

        System.out.println("Sinónimos de 'feliz' después de eliminar:");
        sinonimos = dic.CopiaSinonimoClave("feliz");
        for (int i = 0; i < sinonimos.length; i++) {
            System.out.println("- " + sinonimos[i]);
        }

        // Eliminar una clave
        System.out.println("\nEliminando clave 'triste'...");
        dic.EliminarClave("triste");

        // Mostrar claves finales
        System.out.println("Claves finales:");
        claves = dic.Claves();
        for (int i = 0; i < claves.length; i++) {
            System.out.println("Clave: " + claves[i]);
        }
        
        //ejercicio 3 
        Torneo miTorneo = new Torneo();

        miTorneo.iniciarTorneo();
        miTorneo.agregarUsuarios("Juan", 50);
        miTorneo.agregarUsuarios("Manu", 80);
        miTorneo.agregarUsuarios("Tizi", 60);
        System.out.println("Lista de usuarios:");
        miTorneo.mostrarUsusarios();
        int puntos = miTorneo.buscarUsuario("Juan");
        System.out.println("\nEl puntaje de Juan es: " + puntos);
        int max=miTorneo.puntajeMaximo();
        System.out.println("\nEl puntaje mas alto del torneo es: "+max);
    }
}
