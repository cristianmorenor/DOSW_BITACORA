package dosw.semana_4.patrones.ejercicio1;

public class Checkout {
    private final PaymentFactory factory;

    public Checkout(PaymentFactory factory) {
        this.factory = factory;
    }

    public void pagar(String medio, double amount) {
        PaymentStrategy strategy = factory.create(medio);
        strategy.process(amount);
    }
}