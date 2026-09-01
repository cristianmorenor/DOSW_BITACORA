package dosw.semana_4.patrones.ejercicio2;

public class EmailMessageFactory implements MessageFactory {
    public Message build(OrderEvent event) {
        String html = "<html><body>Pedido " + event.getOrderId()
                + " ahora está: <b>" + event.getEstado() + "</b></body></html>";
        return new Message(html);
    }
}