package dosw.semana_4.patrones.ejercicio4;

public abstract class CharacterDecorator implements Character {
    protected final Character wrapped;

    public CharacterDecorator(Character wrapped) {
        this.wrapped = wrapped;
    }

    public String getNombre() { return wrapped.getNombre(); }

    public Character getWrapped() { return wrapped; }
}