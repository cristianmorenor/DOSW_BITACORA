package dosw.semana_4.patrones;

public class UsaPaymentFactory implements PaymentFactory {
    public PaymentStrategy create(String type) {
        return switch (type) {
            case "PAYPAL" -> new PaypalStrategy();
            case "STRIPE" -> new StripeStrategy();
            case "TARJETA" -> new TarjetaStrategy();
            default -> throw new IllegalArgumentException("Medio no soportado en USA: " + type);
        };
    }
}