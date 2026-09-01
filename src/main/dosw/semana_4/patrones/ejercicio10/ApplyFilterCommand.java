package dosw.semana_4.patrones.ejercicio10;

import java.util.function.Function;

public class ApplyFilterCommand implements ImageCommand {
    private final ImageEditor editor;
    private final String nombreFiltro;
    private final Function<Image, Image> factory;

    public ApplyFilterCommand(ImageEditor editor, String nombreFiltro, Function<Image, Image> factory) {
        this.editor = editor;
        this.nombreFiltro = nombreFiltro;
        this.factory = factory;
    }

    public void execute() {
        editor.addFiltro(this);
    }

    public void undo() {
        editor.removeFiltro(this);
    }

    public Image aplicar(Image imagenActual) {
        return factory.apply(imagenActual);
    }

    public String getNombreFiltro() {
        return nombreFiltro;
    }
}