package dosw.semana_4.patrones.ejercicio1;

public class TarjetaStrategy implements PaymentStrategy {
    public void process(double amount) {
        System.out.println("Procesando $" + amount + " con Tarjeta");
    }
}