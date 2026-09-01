package dosw.semana_4.patrones.ejercicio8;

public class DeliveryService implements OrderObserver {
    public void onOrderConfirmed(Order order) {
        System.out.println("[Domicilio] Preparando ruta para pedido de tamaño " + order.getSize());
    }
}