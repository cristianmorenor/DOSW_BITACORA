package dosw.semana_4.patrones.ejercicio4;

public class SpeedDecorator extends CharacterDecorator {
    public SpeedDecorator(Character wrapped) {
        super(wrapped);
    }

    public int attack() {
        int poder = wrapped.attack();
        System.out.println(getNombre() + " activa Velocidad Extra (+3 poder por golpe rápido)");
        return poder + 3;
    }
}