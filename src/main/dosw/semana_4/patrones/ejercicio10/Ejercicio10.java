package dosw.semana_4.patrones.ejercicio10;

public class Ejercicio10 {
    public static void main(String[] args) {
        ImageEditor editor = new ImageEditor();

        ApplyFilterCommand grayscale = new ApplyFilterCommand(editor, "Blanco y Negro", GrayscaleDecorator::new);
        ApplyFilterCommand sepia = new ApplyFilterCommand(editor, "Sepia", SepiaDecorator::new);
        ApplyFilterCommand brillo = new ApplyFilterCommand(editor, "Brillo", BrightnessDecorator::new);

        System.out.println("--- Aplicando filtros en orden ---");
        grayscale.execute();
        sepia.execute();
        brillo.execute();

        System.out.println("\n--- Deshaciendo el filtro Sepia específicamente (no el último aplicado) ---");
        sepia.undo();

        System.out.println("\n--- Deshaciendo Blanco y Negro también ---");
        grayscale.undo();
    }
}