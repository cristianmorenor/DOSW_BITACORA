package dosw.semana_4.patrones.ejercicio8;

public class KitchenService implements OrderObserver {
    public void onOrderConfirmed(Order order) {
        System.out.println("[Cocina] Preparando: " + order.getMeat() + " con " + order.getToppings());
    }
}