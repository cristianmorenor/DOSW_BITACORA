package dosw.semana_4.patrones.ejercicio10;

public abstract class ImageDecorator implements Image {
    protected final Image wrapped;

    public ImageDecorator(Image wrapped) {
        this.wrapped = wrapped;
    }

    public Image getWrapped() {
        return wrapped;
    }
}