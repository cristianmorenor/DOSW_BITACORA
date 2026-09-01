package dosw.semana_4.patrones.ejercicio1;

public class ColombiaPaymentFactory implements PaymentFactory {
    public PaymentStrategy create(String type) {
        return switch (type) {
            case "PSE" -> new PseStrategy();
            case "NEQUI" -> new NequiStrategy();
            case "TARJETA" -> new TarjetaStrategy();
            default -> throw new IllegalArgumentException("Medio no soportado en Colombia: " + type);
        };
    }
}