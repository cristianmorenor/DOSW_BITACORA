package dosw.semana_4.patrones.ejercicio10;

public class BrightnessDecorator extends ImageDecorator {
    public BrightnessDecorator(Image wrapped) {
        super(wrapped);
    }

    public String render() {
        return wrapped.render() + " + Brillo";
    }
}