package Interfaces;

// Consigna 8: Distribución de Tickets IT - Cola de PRIORIDAD
// Servidor principal roto = prioridad 999 (crítico).
// "No me gusta el fondo de pantalla" = prioridad 0 (puede esperar para siempre).
public interface IDistribucionTicketsIT {
    void inicializarCola();
    void acolarPrioridad(String descripcion, int prioridad);
    void desacolar();
    String primero();
    int prioridad();
    boolean colaVacia();

    void reportarTicket(String descripcion, int nivelCriticidad);
    String atenderTicket();
    String ticketActual();
    int criticidadActual();
    boolean estaVacia();
}
