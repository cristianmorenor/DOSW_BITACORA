package dosw.semana_4.patrones.ejercicio3;

public class ExcelReport extends ReportGenerator {
    protected void applyFormat() {
        contenidoFormateado = String.join(" | ", datosProcesados);
        System.out.println("Formato Excel aplicado (celdas): " + contenidoFormateado);
    }

    protected void exportFile() {
        System.out.println("Guardando reporte.xlsx con contenido:\n" + contenidoFormateado);
    }
}