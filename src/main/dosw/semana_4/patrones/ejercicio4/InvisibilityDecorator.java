package dosw.semana_4.patrones.ejercicio4;

public class InvisibilityDecorator extends CharacterDecorator {
    public InvisibilityDecorator(Character wrapped) {
        super(wrapped);
    }

    public int attack() {
        int poder = wrapped.attack();
        System.out.println(getNombre() + " es invisible (+7 daño por ataque sorpresa)");
        return poder + 7;
    }
}