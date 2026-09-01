package dosw.semana_4.patrones.ejercicio2;

public class OrderEvent {
    private final String orderId;
    private final String estado;

    public OrderEvent(String orderId, String estado) {
        this.orderId = orderId;
        this.estado = estado;
    }

    public String getOrderId() { return orderId; }
    public String getEstado() { return estado; }
}