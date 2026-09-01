package dosw.semana_4.patrones.ejercicio3;

public class PdfReport extends ReportGenerator {
    protected void applyFormat() {
        contenidoFormateado = "<html><body>" + String.join("<br>", datosProcesados) + "</body></html>";
        System.out.println("Formato PDF aplicado: " + contenidoFormateado);
    }

    protected void exportFile() {
        System.out.println("Guardando reporte.pdf con contenido:\n" + contenidoFormateado);
    }
}