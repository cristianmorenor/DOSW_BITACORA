package dosw.semana_4.patrones.ejercicio10;

public class GrayscaleDecorator extends ImageDecorator {
    public GrayscaleDecorator(Image wrapped) {
        super(wrapped);
    }

    public String render() {
        return wrapped.render() + " + Blanco y Negro";
    }
}