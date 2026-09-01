package dosw.semana_4.patrones.ejercicio2;

public class SmsNotifier implements NotificationObserver {
    private final MessageFactory factory = new SmsMessageFactory();

    public void notify(OrderEvent event) {
        Message mensaje = factory.build(event);
        System.out.println("[SMS] Enviando: " + mensaje.getContenido());
    }
}