package dosw.semana_4.patrones.ejercicio10;

public class SepiaDecorator extends ImageDecorator {
    public SepiaDecorator(Image wrapped) {
        super(wrapped);
    }

    public String render() {
        return wrapped.render() + " + Sepia";
    }
}