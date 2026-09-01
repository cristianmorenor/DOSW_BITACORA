package dosw.semana_4.patrones.ejercicio4;

public class ShieldDecorator extends CharacterDecorator {
    public ShieldDecorator(Character wrapped) {
        super(wrapped);
    }

    public int attack() {
        int poder = wrapped.attack();
        System.out.println(getNombre() + " activa Escudo de Hielo (+5 defensa aplicada al golpe)");
        return poder + 5;
    }
}