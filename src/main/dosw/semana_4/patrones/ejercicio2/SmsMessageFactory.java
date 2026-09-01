package dosw.semana_4.patrones.ejercicio2;

public class SmsMessageFactory implements MessageFactory {
    public Message build(OrderEvent event) {
        String texto = "Pedido " + event.getOrderId() + ": " + event.getEstado();
        if (texto.length() > 160) {
            texto = texto.substring(0, 160);
        }
        return new Message(texto);
    }
}