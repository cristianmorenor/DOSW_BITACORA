package dosw.semana_4.patrones.ejercicio1;

public class Ejercicio1 {
    public static void main(String[] args) {
        System.out.println("--- Usuario en Colombia paga con PSE ---");
        Checkout checkoutColombia = new Checkout(new ColombiaPaymentFactory());
        checkoutColombia.pagar("PSE", 150000);

        System.out.println("\n--- Usuario en Colombia paga con Nequi ---");
        checkoutColombia.pagar("NEQUI", 50000);

        System.out.println("\n--- Usuario en USA paga con PayPal ---");
        Checkout checkoutUsa = new Checkout(new UsaPaymentFactory());
        checkoutUsa.pagar("PAYPAL", 99.99);

        System.out.println("\n--- Usuario en USA paga con Stripe ---");
        checkoutUsa.pagar("STRIPE", 49.5);
    }
}