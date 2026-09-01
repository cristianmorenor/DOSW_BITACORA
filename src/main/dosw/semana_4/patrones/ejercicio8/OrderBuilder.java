package dosw.semana_4.patrones.ejercicio8;

import java.util.ArrayList;
import java.util.List;

public class OrderBuilder {
    private Size size;
    private Meat meat;
    private final List<String> toppings = new ArrayList<>();
    private final List<String> sides = new ArrayList<>();

    public OrderBuilder setSize(Size size) {
        this.size = size;
        return this;
    }

    public OrderBuilder setMeat(Meat meat) {
        this.meat = meat;
        return this;
    }

    public OrderBuilder addTopping(String... items) {
        toppings.addAll(List.of(items));
        return this;
    }

    public OrderBuilder addSide(String... items) {
        sides.addAll(List.of(items));
        return this;
    }

    public Order build() {
        if (size == null || meat == null) {
            throw new IllegalStateException("El pedido necesita tamaño y tipo de carne para ser válido");
        }
        return new Order(size, meat, List.copyOf(toppings), List.copyOf(sides));
    }
}