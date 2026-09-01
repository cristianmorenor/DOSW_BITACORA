package dosw.semana_4.patrones.ejercicio1;

public class StripeStrategy implements PaymentStrategy {
    public void process(double amount) {
        System.out.println("Processing $" + amount + " with Stripe");
    }
}