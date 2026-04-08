import Implementacion.*;

public class Main {
    public static void main(String[] args) {

        // === Consigna 1: Padrón Electoral ===
        System.out.println("=== Consigna 1: Padrón Electoral ===");
        // Pertenece() evita el doble voto: antes de registrar se chequea si el legajo ya está.
        PadronElectoral padron = new PadronElectoral();
        padron.inicializarConjunto();
        System.out.println("Voto legajo 1001: " + padron.registrarVoto(1001));  // true
        System.out.println("Voto legajo 1002: " + padron.registrarVoto(1002));  // true
        System.out.println("Voto legajo 1001 (reintento): " + padron.registrarVoto(1001));  // false
        System.out.println("Total votantes: " + padron.totalVotantes());  // 2

        // === Consigna 2: Invitados a la Fiesta ===
        System.out.println("\n=== Consigna 2: Invitados a la Fiesta ===");
        // Agregar duplicado → tamaño NO cambia.
        InvitadosFiesta fiesta = new InvitadosFiesta();
        fiesta.inicializarConjunto();
        fiesta.invitar("Juanchi");
        fiesta.invitar("Luka");
        fiesta.invitar("Manu");
        System.out.println("Invitados: " + fiesta.cantidadInvitados());  // 3
        fiesta.invitar("Juanchi");  // duplicado → se ignora
        System.out.println("Tras agregar Juanchi de nuevo: " + fiesta.cantidadInvitados());  // sigue 3
        System.out.println("¿Está Luka? " + fiesta.estaInvitado("Luka"));  // true
        System.out.println("¿Está Tizi? " + fiesta.estaInvitado("Tizi"));  // false

        // === Consigna 3: Filtro de Spam (Blacklist) ===
        System.out.println("\n=== Consigna 3: Filtro de Spam ===");
        // Verificar mail: tokenizar y usar Pertenece() por cada palabra.
        FiltroSpam filtro = new FiltroSpam();
        filtro.inicializarConjunto();
        filtro.agregarPalabraProhibida("Crypto");
        filtro.agregarPalabraProhibida("Ganá");
        filtro.agregarPalabraProhibida("Premio");
        System.out.println("¿'Ganá un Premio hoy' es spam? " + filtro.esSpam("Ganá un Premio hoy"));  // true
        System.out.println("¿'Reunión de equipo mañana' es spam? " + filtro.esSpam("Reunión de equipo mañana"));  // false
        System.out.println("¿'Invertí en Crypto' es spam? " + filtro.esSpam("Invertí en Crypto"));  // true

        // === Consigna 4: Tags de un Blog ===
        System.out.println("\n=== Consigna 4: Tags del Blog ===");
        // Conjunto porque: sin orden, sin duplicados, no importa cuál se agregó último.
        TagsBlog blog = new TagsBlog();
        blog.inicializarConjunto();
        blog.agregarTag("#Programacion");
        blog.agregarTag("#Java");
        blog.agregarTag("#OOP");
        blog.agregarTag("#Java");  // duplicado → ignorado
        System.out.println("Tags únicos: " + blog.cantidadTags());  // 3
        System.out.println("¿Tiene #Java? " + blog.tieneTag("#Java"));  // true
        blog.eliminarTag("#OOP");
        System.out.println("Tras eliminar #OOP: " + blog.cantidadTags());  // 2

        // === Consigna 5: Gestión de Legajos ===
        System.out.println("\n=== Consigna 5: Gestión de Legajos ===");
        // Alumno anotado en 2 carreras: Pertenece() impide duplicar el ID.
        GestionLegajos legajos = new GestionLegajos();
        legajos.inicializarConjunto();
        System.out.println("Registrar 12345: " + legajos.registrarAlumno(12345));  // true
        System.out.println("Registrar 67890: " + legajos.registrarAlumno(67890));  // true
        System.out.println("Registrar 12345 (2da carrera): " + legajos.registrarAlumno(12345));  // false, no duplica
        System.out.println("Total alumnos: " + legajos.totalAlumnos());  // 2
        legajos.darDeBaja(67890);
        System.out.println("Tras baja 67890: " + legajos.totalAlumnos());  // 1

        // === Consigna 6: Elegir vs Sacar ===
        System.out.println("\n=== Consigna 6: Elegir vs Sacar ===");
        ElegirVsSacar demo = new ElegirVsSacar();
        demo.inicializarConjunto();
        demo.agregar("Elemento A");
        demo.agregar("Elemento B");
        demo.agregar("Elemento C");
        // Elegir dos veces SIN Sacar → mismo elemento (arbitrario, no aleatorio)
        System.out.println("Elegir (1ra vez): " + demo.verSinSacar());  // Elemento A
        System.out.println("Elegir (2da vez, sin Sacar): " + demo.verSinSacar());  // Elemento A (el mismo)
        System.out.println("Tamaño tras dos Elegir: " + demo.tamanio());  // 3, no cambió
        System.out.println("Sacar: " + demo.sacarYMostrar());  // Elemento A, ahora sí se elimina
        System.out.println("Elegir después de Sacar: " + demo.verSinSacar());  // Elemento C (o B, es arbitrario)
        System.out.println("Tamaño ahora: " + demo.tamanio());  // 2
    }
}
