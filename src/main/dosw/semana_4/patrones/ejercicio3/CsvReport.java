package dosw.semana_4.patrones.ejercicio3;

public class CsvReport extends ReportGenerator {
    protected void applyFormat() {
        contenidoFormateado = String.join(",", datosProcesados);
        System.out.println("Formato CSV aplicado: " + contenidoFormateado);
    }

    protected void exportFile() {
        System.out.println("Guardando reporte.csv con contenido:\n" + contenidoFormateado);
    }
}