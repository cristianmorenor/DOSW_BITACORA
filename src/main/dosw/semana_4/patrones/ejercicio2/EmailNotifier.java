package dosw.semana_4.patrones.ejercicio2;

public class EmailNotifier implements NotificationObserver {
    private final MessageFactory factory = new EmailMessageFactory();

    public void notify(OrderEvent event) {
        Message mensaje = factory.build(event);
        System.out.println("[EMAIL] Enviando: " + mensaje.getContenido());
    }
}