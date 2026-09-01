package dosw.semana_4.patrones.ejercicio8;

public class BillingService implements OrderObserver {
    public void onOrderConfirmed(Order order) {
        double precioBase = switch (order.getSize()) {
            case SMALL -> 25000;
            case MEDIUM -> 30000;
            case LARGE -> 45000;
        };
        double total = precioBase + order.getSides().size() * 3000;
        System.out.println("[Facturación] Generando cuenta por: $" + total);
    }
}