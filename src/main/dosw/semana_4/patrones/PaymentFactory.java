package dosw.semana_4.patrones;

public interface PaymentFactory {
    PaymentStrategy create(String type);
}