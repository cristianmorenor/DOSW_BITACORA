package dosw.semana_4.patrones.ejercicio1;

public interface PaymentFactory {
    PaymentStrategy create(String type);
}