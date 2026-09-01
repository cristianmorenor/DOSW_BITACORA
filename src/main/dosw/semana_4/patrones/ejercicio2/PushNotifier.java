package dosw.semana_4.patrones.ejercicio2;

public class PushNotifier implements NotificationObserver {
    private final MessageFactory factory = new PushMessageFactory();

    public void notify(OrderEvent event) {
        Message mensaje = factory.build(event);
        System.out.println("[PUSH] Enviando: " + mensaje.getContenido());
    }
}