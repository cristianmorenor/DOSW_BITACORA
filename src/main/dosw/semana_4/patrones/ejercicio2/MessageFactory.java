package dosw.semana_4.patrones.ejercicio2;

public interface MessageFactory {
    Message build(OrderEvent event);
}