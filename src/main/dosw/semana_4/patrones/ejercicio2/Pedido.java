package dosw.semana_4.patrones.ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private final String orderId;
    private String estado;
    private final List<NotificationObserver> observers = new ArrayList<>();

    public Pedido(String orderId, String estadoInicial) {
        this.orderId = orderId;
        this.estado = estadoInicial;
    }

    public void addObserver(NotificationObserver observer) {
        observers.add(observer);
    }

    public void cambiarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
        OrderEvent event = new OrderEvent(orderId, estado);
        observers.forEach(o -> o.notify(event));
    }
}