import Implementacion.*;

public class Main {
    public static void main(String[] args) {

        // === Consigna 1: Fila del Cajero (Cola COMÚN) ===
        System.out.println("=== Consigna 1: Fila del Cajero (Cola Común) ===");
        // Justificación: Es Cola común. El banco atiende por orden de llegada,
        // no por ningún criterio de privilegio. Acolar = llegar, Desacolar = ser atendido.
        FilaCajero cajero = new FilaCajero();
        cajero.inicializarCola();
        cajero.llegaCliente("Ana");
        cajero.llegaCliente("Bruno");
        cajero.llegaCliente("Carlos");
        System.out.println("Primero en fila: " + cajero.primeroEnFila());
        System.out.println(cajero.atender());
        System.out.println(cajero.atender());
        System.out.println("Ahora primero: " + cajero.primeroEnFila());

        // === Consigna 2: Impresora del Laboratorio (Cola COMÚN) ===
        System.out.println("\n=== Consigna 2: Impresora del Laboratorio (Cola Común) ===");
        ImpresoraLaboratorio impresora = new ImpresoraLaboratorio();
        impresora.inicializarCola();
        impresora.recibirArchivo("TP_Juanchi.pdf");
        impresora.recibirArchivo("TP_Luka.pdf");
        impresora.recibirArchivo("TP_Manu.pdf");
        impresora.recibirArchivo("TP_Fran.pdf");
        impresora.recibirArchivo("TP_Tizi.pdf");
        // Orden de salida: FIFO, el que llegó primero se imprime primero
        while (!impresora.estaVacia()) System.out.println(impresora.imprimir());

        // === Consigna 3: Guardia del Hospital - Triage (Cola de PRIORIDAD) ===
        System.out.println("\n=== Consigna 3: Guardia Hospital - Triage (Cola Prioridad) ===");
        // Prioridades: raspón=1, fractura=50, infarto=100
        GuardiaHospital guardia = new GuardiaHospital();
        guardia.inicializarCola();
        guardia.llegar("Pibe con raspón", 1);
        guardia.llegar("Jubilado con bobazo (infarto)", 100);
        guardia.llegar("Señora con fractura de cadera", 50);
        System.out.println("Próximo a atender: " + guardia.proximoPaciente());
        while (!guardia.estaVacia()) System.out.println(guardia.atender());

        // === Consigna 4: Examen Final (Cola de PRIORIDAD) ===
        System.out.println("\n=== Consigna 4: Examen Final (Cola Prioridad) ===");
        // Regular llegó 8:00, Promocionado llegó 8:30 → Promocionado sale primero igual.
        ExamenFinal examen = new ExamenFinal();
        examen.inicializarCola();
        examen.anotarse("Regular (llegó 8:00)", ExamenFinal.REGULAR);
        examen.anotarse("Promocionado (llegó 8:30)", ExamenFinal.PROMOCIONADO);
        examen.anotarse("Regular (llegó 8:45)", ExamenFinal.REGULAR);
        System.out.println("Primero en llamar: " + examen.proximoAlumno());
        while (!examen.estaVacia()) System.out.println("Llamando a: " + examen.llamarSiguiente());

        // === Consigna 5: Buffet de la Facultad (Cola COMÚN) ===
        System.out.println("\n=== Consigna 5: Buffet Facultad (Cola Común) ===");
        // Operación clave: Acolar. Al agregar siempre al final, es imposible colarse.
        BuffetFacultad buffet = new BuffetFacultad();
        buffet.inicializarCola();
        buffet.hacerFila("Tizi");
        buffet.hacerFila("Luro");
        buffet.hacerFila("Vibe Coder (intentó colarse pero Acolar lo manda al final)");
        while (!buffet.estaVacia()) System.out.println(buffet.servirSiguiente());

        // === Consigna 6: Procesador de Tareas / OS Scheduler (Cola de PRIORIDAD) ===
        System.out.println("\n=== Consigna 6: OS Scheduler (Cola Prioridad) ===");
        // Sistema=50, Usuario=10. Sobrecarga: Spotify espera hasta que terminen los del sistema.
        ProcesadorTareas os = new ProcesadorTareas();
        os.inicializarCola();
        os.agregarProceso("Spotify (usuario)", 10);
        os.agregarProceso("Gestor de memoria (sistema)", 50);
        os.agregarProceso("Chrome (usuario)", 10);
        os.agregarProceso("Scheduler (sistema)", 50);
        while (!os.estaVacia()) System.out.println(os.ejecutarSiguiente());

        // === Consigna 7: Embarque de Aerolíneas (Cola de PRIORIDAD) ===
        System.out.println("\n=== Consigna 7: Embarque Aerolíneas (Cola Prioridad) ===");
        // Misma prioridad: el orden no está garantizado (no hay desempate por llegada).
        EmbarqueAerolineas avion = new EmbarqueAerolineas();
        avion.inicializarCola();
        avion.abordar("Turista A", EmbarqueAerolineas.TURISTA);
        avion.abordar("Business B", EmbarqueAerolineas.BUSINESS);
        avion.abordar("Turista C", EmbarqueAerolineas.TURISTA);  // misma prioridad que A
        avion.abordar("Movilidad Reducida D", EmbarqueAerolineas.MOVILIDAD_REDUCIDA);
        while (!avion.estaVacia()) System.out.println(avion.embarcarSiguiente());

        // === Consigna 8: Distribución de Tickets IT (Cola de PRIORIDAD) ===
        System.out.println("\n=== Consigna 8: Tickets IT (Cola Prioridad) ===");
        // Servidor roto = 999 (crítico absoluto). Fondo de pantalla = 0 (puede esperar forever).
        DistribucionTicketsIT tickets = new DistribucionTicketsIT();
        tickets.inicializarCola();
        tickets.reportarTicket("No me gusta el fondo de pantalla", 0);
        tickets.reportarTicket("El mouse no funciona", 5);
        tickets.reportarTicket("Se rompió el servidor principal", 999);
        tickets.reportarTicket("No llega el WiFi al baño", 2);
        while (!tickets.estaVacia()) System.out.println(tickets.atenderTicket());
    }
}
