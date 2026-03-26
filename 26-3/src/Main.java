import Implementacion.*;

public class Main {
    public static void main(String[] args) {

        // === Consigna 1: Historial de Navegación ===
        System.out.println("=== Consigna 1: Historial de Navegación ===");
        HistorialNavegacion historial = new HistorialNavegacion();
        historial.inicializar();
        historial.visitar("fi.uba.ar");
        historial.visitar("campus.utn.edu.ar");
        historial.visitar("stackoverflow.com");
        System.out.println("Página actual: " + historial.paginaActual());
        historial.atras();
        System.out.println("Tras 'Atrás': " + historial.paginaActual());
        historial.atras();
        System.out.println("Tras 'Atrás': " + historial.paginaActual());

        // === Consigna 2: Editor de Código (Undo) ===
        System.out.println("\n=== Consigna 2: Editor de Código (Undo) ===");
        EditorCodigo editor = new EditorCodigo();
        editor.inicializar();
        editor.hacerCambio("int x = 0;");
        editor.hacerCambio("int x = 5;");
        editor.hacerCambio("int x = 5; x++;");
        System.out.println("Deshacer: " + editor.deshacer());
        System.out.println("Deshacer: " + editor.deshacer());
        System.out.println("Sin cambios: " + editor.sinCambios());

        // === Consigna 3: Balanceo de Paréntesis ===
        System.out.println("\n=== Consigna 3: Balanceo de Paréntesis ===");
        BalanceoParentesis balanceo = new BalanceoParentesis();
        balanceo.inicializar();
        System.out.println("( ( a + b ) * c ) → " + balanceo.estaBalanceada("( ( a + b ) * c )")); // true
        System.out.println("( a + b           → " + balanceo.estaBalanceada("( a + b"));           // false
        System.out.println("a + b )           → " + balanceo.estaBalanceada("a + b )"));           // false

        // === Consigna 4: Reversión de Strings ===
        System.out.println("\n=== Consigna 4: Reversión de Strings ===");
        ReversionStrings reversion = new ReversionStrings();
        reversion.inicializar();
        System.out.println("ALGORITMOS → " + reversion.invertir("ALGORITMOS"));
        System.out.println("HOLA       → " + reversion.invertir("HOLA"));

        // === Consigna 5: Pila de Llamadas (Call Stack) ===
        System.out.println("\n=== Consigna 5: Pila de Llamadas ===");
        PilaLlamadas callStack = new PilaLlamadas();
        callStack.inicializar();
        callStack.llamar("Main()");
        callStack.llamar("CalcularPromedio()");
        callStack.llamar("Sumar()");
        System.out.println("Función en ejecución: " + callStack.funcionActual()); // Sumar()
        callStack.retornar();
        System.out.println("Tras retorno: " + callStack.funcionActual());         // CalcularPromedio()
        callStack.retornar();
        System.out.println("Tras retorno: " + callStack.funcionActual());         // Main()

        // === Consigna 6: Navegación de Directorios ===
        System.out.println("\n=== Consigna 6: Navegación de Directorios ===");
        NavegacionDirectorios dirs = new NavegacionDirectorios();
        dirs.inicializar();
        dirs.entrar("C:/");
        dirs.entrar("Usuarios");
        dirs.entrar("Documentos");
        System.out.println("Directorio actual: " + dirs.directorioActual()); // Documentos
        dirs.subirNivel();
        System.out.println("Subir un nivel: " + dirs.directorioActual());    // Usuarios
        dirs.subirNivel();
        System.out.println("Subir un nivel: " + dirs.directorioActual());    // C:/
        dirs.subirNivel();
        System.out.println("¿En raíz? " + dirs.enRaiz());                   // true
    }
}
