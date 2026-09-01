package dosw.semana_4.patrones.ejercicio9;

public abstract class Validator {
    private Validator next;

    public Validator setNext(Validator next) {
        this.next = next;
        return next;
    }

    public void validate(Credentials credentials) {
        check(credentials);
        if (next != null) {
            next.validate(credentials);
        }
    }

    protected abstract void check(Credentials credentials);
}