package dosw.semana_4.patrones.ejercicio8;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final Size size;
    private final Meat meat;
    private final List<String> toppings;
    private final List<String> sides;
    private final List<OrderObserver> observers = new ArrayList<>();

    public Order(Size size, Meat meat, List<String> toppings, List<String> sides) {
        this.size = size;
        this.meat = meat;
        this.toppings = toppings;
        this.sides = sides;
    }

    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    public void confirm() {
        System.out.println("Pedido confirmado: " + this);
        observers.forEach(o -> o.onOrderConfirmed(this));
    }

    public Size getSize() { return size; }
    public Meat getMeat() { return meat; }
    public List<String> getToppings() { return toppings; }
    public List<String> getSides() { return sides; }

    public String toString() {
        return size + " " + meat + " con " + toppings + " y acompañamientos " + sides;
    }
}