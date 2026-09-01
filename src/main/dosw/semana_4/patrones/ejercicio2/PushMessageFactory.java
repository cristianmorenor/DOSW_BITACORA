package dosw.semana_4.patrones.ejercicio2;

public class PushMessageFactory implements MessageFactory {
    public Message build(OrderEvent event) {
        String json = "{\"orderId\":\"" + event.getOrderId() + "\",\"estado\":\"" + event.getEstado() + "\"}";
        return new Message(json);
    }
}