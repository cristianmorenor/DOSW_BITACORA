package dosw.semana_4.patrones.ejercicio2;

public class Ejercicio2 {
    public static void main(String[] args) {
        Pedido pedido = new Pedido("ORD-001", "pendiente");

        pedido.addObserver(new EmailNotifier());
        pedido.addObserver(new SmsNotifier());
        pedido.addObserver(new PushNotifier());

        System.out.println("--- Pedido cambia a: enviado ---");
        pedido.cambiarEstado("enviado");

        System.out.println("\n--- Pedido cambia a: entregado ---");
        pedido.cambiarEstado("entregado");
    }
}